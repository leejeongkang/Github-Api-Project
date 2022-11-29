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
    final String owner = "mobigen";

    private List<HashMap<String, Object>> getName (JsonResult result) {
        List<HashMap<String, Object>> list = (List<HashMap<String, Object>>) result.getData();

        List<HashMap<String, Object>> nameList = new ArrayList<>();

        for (HashMap<String, Object> item : list) {
            HashMap<String, Object> nameMap = new HashMap<>();
            nameMap.put("name", item.get("name"));
            nameList.add(nameMap);
        }
        return nameList;
    }

    public Object repoList() {
        JsonResult result = this.restAPI.get("https://api.github.com/orgs/"+ owner + "/repos",
                null, githubApiToken.accessToken());

        return getName(result);
    }

    public Object branchList(String repo) {
        JsonResult result = this.restAPI.get("https://api.github.com/repos" + owner + "/" + repo + "/branches",
                null, githubApiToken.accessToken());

        return getName(result);
    }

    public Integer commitCnt(String repo) {
        JsonResult result = this.restAPI.get("https://api.github.com/repos/" + owner + "/" + repo + "/commits?per_page=100",
                null, githubApiToken.accessToken());

        return getName(result).size();
    }

    public Integer prCnt(String repo) {
        JsonResult result = this.restAPI.get("https://api.github.com/repos/" + owner + "/" + repo + "/pulls?state=all&per_page=100",
                null, githubApiToken.accessToken());

        return getName(result).size();
    }

    public Integer userCnt(String repo) {
        JsonResult result = this.restAPI.get("https://api.github.com/repos/" + owner + "/" + repo + "/contributors?state=all",
                null, githubApiToken.accessToken());

        return getName(result).size();
    }

    public Integer branchCnt(String repo) {
        JsonResult result = this.restAPI.get("https://api.github.com/repos/" + owner + "/" + repo + "/branches?state=all",
                null, githubApiToken.accessToken());

        return getName(result).size();
    }

    public Integer commitCntByUser(String repo, String user) {
        HashMap<String, String> userMap = new HashMap<>();
        userMap.put("author", user);

        JsonResult result =
                this.restAPI.get("https://api.github.com/repos/" + owner + "/" + repo + "/commits?state=all",
                        userMap, githubApiToken.accessToken());

        return getName(result).size();
    }
    public Integer prCntByUser(String repo, String user) {
        HashMap<String, String> userMap = new HashMap<>();
        userMap.put("author", user);

        JsonResult result =
                this.restAPI.get("https://api.github.com/repos/" + owner + "/" + repo +"/pulls?state=all",
                        userMap, githubApiToken.accessToken());

        return getName(result).size();
    }

    public Integer commitCntByDate(String repo, String datePick) {
        HashMap<String, String> dateMap = getDate(datePick);

        JsonResult result =
                this.restAPI.get("https://api.github.com/repos" + owner + "/" + repo + "/commits?state=all",
                        dateMap, githubApiToken.accessToken());

        return getName(result).size();
    }

    public Integer prCntByDate(String repo, String datePick) {
        HashMap<String, String> dateMap = getDate(datePick);

        JsonResult result =
                this.restAPI.get("https://api.github.com/repos" + owner + "/" + repo + "/pulls?state=all",
                        dateMap, githubApiToken.accessToken());

        return getName(result).size();
    }

    private HashMap<String, String> getDate(String datePick) {
        Date date = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, 23);
        calendar.add(Calendar.MINUTE, 59);
        calendar.add(Calendar.SECOND, 59);
        String untilDate = datePick + calendar;

        HashMap<String, String> map = new HashMap<>();
        map.put("since", datePick);
        map.put("until", untilDate);

        return map;
    }
}
