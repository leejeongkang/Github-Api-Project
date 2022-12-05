package com.mobigen.GithubApiProject.Repo;

import com.mobigen.GithubApiProject.Config.GithubApiToken;
import com.mobigen.framework.result.JsonResult;
import com.mobigen.framework.utility.restful.RestAPI;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class RepoService {

    private final RestAPI restAPI;
    private final GithubApiToken githubApiToken;
    private final UrlService urlService;
    private List<Map<String, Object>> getName (JsonResult result) {
        List<Map<String, Object>> list = (List<Map<String, Object>>) result.getData();

        String [] keys = { "name", "id" };

        for (Map<String, Object> item : list) {
            Set<String> keySet = new HashSet<String>();
            keySet.addAll(item.keySet());
            keySet.removeAll(Arrays.asList(keys));
            item.keySet().removeAll(keySet);
        }
        return list;
    }
    public Object repoList() {
        JsonResult result = this.restAPI.get(urlService.getRepoListURL(),null, githubApiToken.accessToken());

        return getName(result);
    }

    public Object branchList(String repo) {
        JsonResult result = this.restAPI.get(urlService.getBranchListURL(repo),null, githubApiToken.accessToken());

        return getName(result);
    }

    public Integer commitCount(String repo) {
        JsonResult result = this.restAPI.get(urlService.getCommitCountURL(repo),null, githubApiToken.accessToken());

        return getName(result).size();
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

    public Integer commitCountByUser(String repo, String user) {
        Map<String, String> userMap =  new HashMap<>();
        userMap.put("author", user);

        JsonResult result = this.restAPI.get(urlService.getCommitCountByUserURL(repo), userMap, githubApiToken.accessToken());

        return getName(result).size();
    }
    public Integer prCountByUser(String repo, String user) {
        Map<String, String> userMap = new HashMap<>();
        userMap.put("author", user);

        JsonResult result = this.restAPI.get(urlService.getPrCountByUserURL(repo), userMap, githubApiToken.accessToken());

        return getName(result).size();
    }

    public Integer commitCountByDate(String repo, String datePick) {
        Map<String, String> dateMap = getDate(datePick);

        JsonResult result = restAPI.get(urlService.getCommitCountByDateURL(repo), dateMap, githubApiToken.accessToken());

        return getName(result).size();
    }

    public Integer prCountByDate(String repo, String datePick) {
        Map<String, String> dateMap = getDate(datePick);

        JsonResult result = restAPI.get(urlService.getPrCountByDateURL(repo), dateMap, githubApiToken.accessToken());

        return getName(result).size();
    }

    private Map<String, String> getDate(String datePick) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.HOUR, 23);
        calendar.add(Calendar.MINUTE, 59);
        calendar.add(Calendar.SECOND, 59);
        String untilDate = datePick + calendar;

        Map<String, String> map = new HashMap<>();
        map.put("since", datePick);
        map.put("until", untilDate);

        return map;
    }
}
