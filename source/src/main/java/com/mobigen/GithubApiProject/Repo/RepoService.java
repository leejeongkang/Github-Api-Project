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
    static final String owner = "mobigen";

    private List<Map<String, Object>> getName (JsonResult result) {
        List<Map<String, Object>> list = (List<Map<String, Object>>) result.getData();

        List<Map<String, Object>> nameList = new ArrayList<>();

        for (Map<String, Object> item : list) {
            Map<String, Object> nameMap = new HashMap<>();
            nameMap.put("name", item.get("name"));
            nameList.add(nameMap);
        }
        return nameList;
    }
    private String getURL(String repo, String key) {

        final String githubURL = "https://api.github.com/repos/" + owner + "/" + repo;

        final String repoListURL = "https://api.github.com/orgs/" + owner + "/repos";
        final String branchListURL = githubURL + "/branches";
        final String commitCountURL = githubURL + "/commits?per_page=100";
        final String prCountURL = githubURL + "/pulls?state=all&per_page=100";
        final String userCountURL = githubURL + "/contributors?state=all";
        final String branchCountURL = githubURL + "/branches?state=all";
        final String commitCountByUserURL = githubURL + "/commits?state=all";
        final String prCountByUserURL = githubURL +"/pulls?state=all";
        final String commitCountByDateURL = githubURL + "/commits?state=all";
        final String prCountByDateURL = githubURL + "/pulls?state=all";

        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("repoListURL", repoListURL);
        stringMap.put("branchListURL", branchListURL);
        stringMap.put("commitCountURL", commitCountURL);
        stringMap.put("prCountURL", prCountURL);
        stringMap.put("userCountURL", userCountURL);
        stringMap.put("branchCountURL", branchCountURL);
        stringMap.put("commitCountByUserURL", commitCountByUserURL);
        stringMap.put("prCountByUserURL", prCountByUserURL);
        stringMap.put("commitCountByDateURL", commitCountByDateURL);
        stringMap.put("prCountByDateURL", prCountByDateURL);

        return stringMap.get(key);
    }

    public Object repoList() {
        JsonResult result = this.restAPI.get(getURL(null,"repoListURL"),null, githubApiToken.accessToken());

        return getName(result);
    }

    public Object branchList(String repo) {
        JsonResult result = this.restAPI.get(getURL(repo,"branchListURL"),null, githubApiToken.accessToken());

        return getName(result);
    }

    public Integer commitCount(String repo) {
        JsonResult result = this.restAPI.get(getURL(repo,"commitCountURL"),null, githubApiToken.accessToken());

        return getName(result).size();
    }

    public Integer prCount(String repo) {
        JsonResult result = this.restAPI.get(getURL(repo,"prCountURL"),null, githubApiToken.accessToken());

        return getName(result).size();
    }

    public Integer userCount(String repo) {
        JsonResult result = this.restAPI.get(getURL(repo,"userCount"),null, githubApiToken.accessToken());

        return getName(result).size();
    }

    public Integer branchCount(String repo) {
        JsonResult result = this.restAPI.get(getURL(repo,"branchCount"),null, githubApiToken.accessToken());

        return getName(result).size();
    }

    public Integer commitCountByUser(String repo, String user) {
        Map<String, String> userMap =  new HashMap<>();
        userMap.put("author", user);

        JsonResult result = this.restAPI.get(getURL(repo,"commitCountByUserURL"), userMap, githubApiToken.accessToken());

        return getName(result).size();
    }
    public Integer prCountByUser(String repo, String user) {
        Map<String, String> userMap = new HashMap<>();
        userMap.put("author", user);

        JsonResult result = this.restAPI.get(getURL(repo,"prCountByUser"), userMap, githubApiToken.accessToken());

        return getName(result).size();
    }

    public Integer commitCountByDate(String repo, String datePick) {
        Map<String, String> dateMap = getDate(datePick);

        JsonResult result = restAPI.get(getURL(repo,"commitCountByDateURL"), dateMap, githubApiToken.accessToken());

        return getName(result).size();
    }

    public Integer prCountByDate(String repo, String datePick) {
        Map<String, String> dateMap = getDate(datePick);

        JsonResult result = restAPI.get(getURL(repo, "prCountByDateURL"), dateMap, githubApiToken.accessToken());

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
