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

    private ArrayList<HashMap<String, Object>> getName(JsonResult result) {
        ArrayList<LinkedHashMap<String, Object>> arrayList =
                (ArrayList<LinkedHashMap<String, Object>>) result.getData();

        ArrayList<HashMap<String, Object>> nameList = new ArrayList<>();

        for (LinkedHashMap<String, Object> item : arrayList) {
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

}
