package com.mobigen.githubApiProject.repo;

import com.mobigen.githubApiProject.config.GithubApiToken;
import com.mobigen.framework.result.JsonResult;
import com.mobigen.framework.utility.restful.RestAPI;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@AllArgsConstructor
@Slf4j
public class RepoService {

    private final RestAPI restAPI;
    private final GithubApiToken githubApiToken;
    private final UrlService urlService;

    private List<Map<String, Object>> getName(JsonResult result) {
        List<Map<String, Object>> list = (List<Map<String, Object>>) result.getData();

        String[] keys = {"name", "date"};
        for (Map<String, Object> item : list) {
            Set<String> keySet = new HashSet<String>();
            keySet.addAll(item.keySet());
            keySet.removeAll(Arrays.asList(keys));
            item.keySet().removeAll(keySet);
        }
        return list;
    }
    private List<Map<String, Object>> getCommit(JsonResult result) {
        List<Map<String, Object>> list = (List<Map<String, Object>>) result.getData();

        String[] keys = {"sha", "commit"};
        for (Map<String, Object> item : list) {
            Set<String> keySet = new HashSet<String>();
            keySet.addAll(item.keySet());
            keySet.removeAll(Arrays.asList(keys));
            item.keySet().removeAll(keySet);
        }
        return list;
    }

    private List<Map<String, Object>> getPr(JsonResult result) {
        List<Map<String, Object>> list = (List<Map<String, Object>>) result.getData();
        String[] keys = {"number", "id", "state", "created_at"};
        for (Map<String, Object> item : list) {
            Set<String> keySet = new HashSet<String>();
            keySet.addAll(item.keySet());
            keySet.removeAll(Arrays.asList(keys));
            item.keySet().removeAll(keySet);
        }
        return list;
    }
    private Map<String, Integer> getDate(JsonResult result) {
        List<Map<String, Object>> list = (List<Map<String, Object>>) result.getData();
        SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd");
        List<String> dateList = new ArrayList<>();
        for (Map<String, Object> item : list) {
            //commit>author>date
            Map<String, Object> commitMap = new HashMap<>();
            commitMap = (Map<String, Object>) item.get("commit");

            Map<String, Object> authorMap = new HashMap<>();
            authorMap = (Map<String, Object>) commitMap.get("author");

            String date = authorMap.get("date").toString();
            Date newDate = null;
            try {
                newDate = input.parse(date);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            String resultDate = output.format(newDate);
            dateList.add(resultDate);
        }
        Map<String, Integer> countMap = new HashMap<>();
        for(String item : dateList) {
            int count = Collections.frequency(dateList, item);
            countMap.put(item, count);
        }
        log.info(countMap.toString());

        return countMap;
    }
    public List<Map<String, Object>> repoList() {
        JsonResult result = restAPI.get(urlService.getRepoListURL(),null, githubApiToken.accessToken());

        return getName(result);
    }

    public Object branchList(String repo) {
        JsonResult result = this.restAPI.get(urlService.getBranchListURL(repo),null, githubApiToken.accessToken());

        return getName(result);
    }

    public Object commitCount(String repo, int currentPage) {
        JsonResult result = this.restAPI.get(urlService.getCommitCountURL(repo), githubApiToken.accessToken());
        int cnt = getCommit(result).size();
        Integer page;
        int newCnt = 0;
        //github에서 제공하는 디폴트값이 30임
        int defaultValue = 30;
        if (cnt == defaultValue) {
            for (page = 2 ; ; page++) {
                JsonResult newResult = this.restAPI.get(urlService.getCommitCountURL(repo), pageParams(page), githubApiToken.accessToken());
                newCnt = getCommit(newResult).size();

                if (newCnt != defaultValue)
                    break;
            }
        } else {
            return cnt;
        }
        //for문 돌면서 page값이 지정되었을텐데 그거랑 newCnt값으로 전체 커밋건수 계산
        int count = (page - 1) * defaultValue + newCnt;
        //int currentPage;
        int totalPageCount = page;
        int currentBlock = 0;

        int blockSize = 10;

        for(int i=0; ;i++)
        {
            //현재 페이지가 몇번째 블록?에 있는지 찾아서
            if( blockSize*i < currentPage && blockSize*(i+1) >= currentPage)
            {
                //찾으면 넣어주고 break
                currentBlock = i;
                break;
            }
        }
        int beginPage = (currentBlock * blockSize) + 1;
        int endPage = (currentBlock + 1) * blockSize;

        if(totalPageCount<endPage)
            endPage = totalPageCount;

        List<Integer> pageList = new ArrayList<>();
        for(int i = beginPage; i<= endPage;i++)
        {
            pageList.add(i);
            //pageList리스트에 i값 넣어주기
            //1,2,3,4,5,6,7,8
        }
        Map<String, Object> map = new HashMap<>();
        map.put("commitCount", count);
        map.put("totalPage", page);
        map.put("list", pageList);
        map.put("beginPage", beginPage);
        map.put("endPage", endPage);
        map.put("currentPage", currentPage);
        return map;
    }

    public Integer prCount(String repo) {
        JsonResult result = this.restAPI.get(urlService.getPrCountURL(repo),null, githubApiToken.accessToken());

        return getName(result).size();
    }

    public Integer userCount(String repo) {
        JsonResult result = this.restAPI.get(urlService.getUserCountURL(repo),null, githubApiToken.accessToken());

        return getName(result).size();
    }

    public Integer branchCount(String repo) {
        JsonResult result = this.restAPI.get(urlService.getBranchCountURL(repo),null, githubApiToken.accessToken());

        return getName(result).size();
    }

    public Object commitCountByUser(String repo, Integer page) {
        JsonResult result = this.restAPI.get(urlService.getCommitCountByUserURL(repo), pageParams(page), githubApiToken.accessToken());

        return getCommit(result);
    }
    public Object prCountByUser(String repo, Integer page) {
        JsonResult result = this.restAPI.get(urlService.getPrCountByUserURL(repo), pageParams(page), githubApiToken.accessToken());

        return result;
    }
    public Object commitCountByDate(String repo, String since, String until) {
        JsonResult result = restAPI.get(urlService.getCommitCountByDateURL(repo), dateParams(since, until), githubApiToken.accessToken());

        return getDate(result);
    }

    public Integer prCountByDate(String repo) {
        JsonResult result = restAPI.get(urlService.getPrCountByDateURL(repo), githubApiToken.accessToken());
        return getPr(result).size();
    }
    private Map<String, Object> pageParams(Integer page) {
        Map<String, Object> map = new HashMap<>();
        map.put("page", page);
        map.put("state", "all");
        return map;
    }
    private Map<String, String> dateParams(String since, String until) {
        Map<String, String> map = new HashMap<>();
        map.put("since", since);
        map.put("until", until);
        return map;
    }
}
