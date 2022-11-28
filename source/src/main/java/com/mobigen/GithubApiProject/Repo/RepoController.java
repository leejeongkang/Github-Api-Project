package com.mobigen.GithubApiProject.Repo;

import com.mobigen.GithubApiProject.Config.GithubApiToken;
import com.mobigen.framework.result.JsonResult;
import com.mobigen.framework.result.annotation.ResponseJsonResult;
import com.mobigen.framework.utility.restful.RestAPI;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Slf4j
@RequestMapping("/repo-api")
@Controller
@AllArgsConstructor
public class RepoController {

    private final RestAPI restAPI;
    private final GithubApiToken githubApiToken;
    final String owner = "mobigen";

    @ResponseJsonResult
    @GetMapping("/repos")
    public Object repoList() {
        JsonResult result = this.restAPI.get("https://api.github.com/orgs/"+ owner + "/repos",
                                    null, githubApiToken.accessToken());

        ArrayList<LinkedHashMap<String, Object>> arrayList =
                (ArrayList<LinkedHashMap<String, Object>>) result.getData();

        ArrayList<HashMap<String, Object>> nameList = new ArrayList<>();

        for (LinkedHashMap<String, Object> item : arrayList) {
            HashMap<String, Object> nameMap = new HashMap<>();
            nameMap.put("name", item.get("name"));
            nameList.add(nameMap);
        }
        log.info("repo list");

        return nameList;
    }

    @ResponseJsonResult
    @GetMapping("/{repo}/branch-list")
    public Object branchList(@PathVariable String repo) {
        JsonResult result = this.restAPI.get("https://api.github.com/repos" + owner + "/" + "GitTest" + "/branches",
                                                null, githubApiToken.accessToken());

        ArrayList<LinkedHashMap<String, Object>> arrayList =
                (ArrayList<LinkedHashMap<String, Object>>) result.getData();

        ArrayList<HashMap<String, Object>> nameList = new ArrayList<>();
        for (LinkedHashMap<String, Object> item : arrayList) {
            HashMap<String, Object> nameMap = new HashMap<>();
            nameMap.put("name", item.get("name"));
            nameList.add(nameMap);
        }
        log.info("branch list");
        return nameList;
    }

    @ResponseJsonResult
    @GetMapping("/commit-count")
    public Object commitCnt() {
        JsonResult result = this.restAPI.get("https://api.github.com/repos/" + owner + "/" + "GitTest/commits?state=all",
                                            null, githubApiToken.accessToken());

        log.info("commit count");
        return result;
    }

    @ResponseJsonResult
    @GetMapping("/{repo}/pr-count")
    public Object prCnt(@PathVariable String repo) {
        JsonResult result = this.restAPI.get("https://api.github.com/repos" + owner + "/" + repo + "/pulls?state=all",
                                            null, githubApiToken.accessToken());

        log.info("pr count");
        return result;
    }

    @ResponseJsonResult
    @GetMapping("/{repo}/user-cnt")
    public Object userCnt(@PathVariable String repo) {
        JsonResult result = this.restAPI.get("https://api.github.com/repos/" + owner + "/" + repo + "/contributors?state=all",
                                            null, githubApiToken.accessToken());

        log.info("user count");
        return result;
    }

    @ResponseJsonResult
    @GetMapping("{repo}/branch-cnt")
    public Object branchCnt(@PathVariable String repo){
        JsonResult result = this.restAPI.get("https://api.github.com/repos/" + owner + "/" + repo + "branches?state=all",
                                            null, githubApiToken.accessToken());

        log.info("branch count");
        return result;
    }

    @ResponseJsonResult
    @GetMapping("/{repo}/commits/{user}")
    public Object commitCntByUser(@PathVariable String repo,
                                  @PathVariable String user) {

        HashMap<String, String> userMap = new HashMap<>();
        userMap.put("author", user);

        JsonResult result =
                this.restAPI.get("https://api.github.com/repos/" + owner + "/" + repo + "/commits?state=all",
                userMap, githubApiToken.accessToken());

        log.info("commit by user count");
        return result;
    }

    @ResponseJsonResult
    @GetMapping("/{repo}/pr/{user}")
    public Object prCntByUser(@PathVariable String repo,
                              @PathVariable String user) {
        HashMap<String, String> userMap = new HashMap<>();
        userMap.put("author", user);

        JsonResult result =
                this.restAPI.get("https://api.github.com/repos/" + owner + "/" + repo +"/pulls?state=all",
                userMap, githubApiToken.accessToken());

        log.info("pr count by user");
        return result;
    }

    @ResponseJsonResult
    @GetMapping("/{repo}/pr/{datePick}")
    public Object prCntByDate (@PathVariable String repo,
                               @PathVariable String datePick) {

        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, 23);
        calendar.add(Calendar.MINUTE, 59);
        calendar.add(Calendar.SECOND, 59);

        String untilDate = datePick + calendar;

        HashMap<String, String> dateMap = new HashMap<>();
        dateMap.put("since", datePick);
        dateMap.put("until", untilDate);

        JsonResult result =
                this.restAPI.get("https://api.github.com/repos" + owner + "/" + repo + "/pulls?state=all",
                dateMap, githubApiToken.accessToken());

        log.info("pr count by date");
        return result;
    }

    @ResponseJsonResult
    @GetMapping("/{repo}/commits/{datePick}")
    public Object commitCntByDate (@PathVariable String repo,
                                   @PathVariable String datePick) {

        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, 23);
        calendar.add(Calendar.MINUTE, 59);
        calendar.add(Calendar.SECOND, 59);
        String untilDate = datePick + calendar;

        HashMap<String, String> dateMap = new HashMap<>();
        dateMap.put("since", datePick);
        dateMap.put("until", untilDate);

        JsonResult result =
                this.restAPI.get("https://api.github.com/repos" + owner + "/" + repo + "/commits?state=all",
                dateMap, githubApiToken.accessToken());

        log.info("commit count by date");
        return result;
    }
}
