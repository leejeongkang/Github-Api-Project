package com.mobigen.githubApiProject.repo;

import com.mobigen.framework.result.annotation.ResponseJsonResult;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@RequestMapping("/repo-api")
@Controller
@AllArgsConstructor
public class RepoController {

    private final RepoService service;

    @ResponseJsonResult
    @GetMapping("/repos")
    public Object repoList() {

        log.info("repo list");
        return service.repoList();
    }

    @ResponseJsonResult
    @GetMapping("/branch-list/{repo}")
    public Object branchList(@PathVariable String repo) {

        log.info("branch list");
        return service.branchList(repo);
    }

    @ResponseJsonResult
    @GetMapping("/{repo}/commit-cnt")
    public Object commitCount(@PathVariable String repo,
                              @RequestParam(defaultValue = "1") int currentPage ) {

        log.info("commit count");
        return service.commitCount(repo, currentPage);
    }
    @ResponseJsonResult
    @GetMapping("/{repo}/pr-cnt")
    public Object prCount(@PathVariable String repo) {

        log.info("pr count");
        return service.prCount(repo);
    }

    @ResponseJsonResult
    @GetMapping("/{repo}/user-cnt")
    public Object userCount(@PathVariable String repo) {

        log.info("user count");
        return service.userCount(repo);
    }

    @ResponseJsonResult
    @GetMapping("/{repo}/branch-cnt")
    public Object branchCount(@PathVariable String repo){

        log.info("branch count");
        return service.branchCount(repo);
    }

    @ResponseJsonResult
    @GetMapping("/{repo}/commit-cnt/user")
    public Object commitCountByUser(@PathVariable String repo,
                                    @RequestParam(required = false) Integer page) {
        log.info("commit by user count");
        log.info(repo);
        log.info("commit page: " + String.valueOf(page));
        return service.commitCountByUser(repo, page);
    }

    @ResponseJsonResult
    @GetMapping("/{repo}/pr-cnt/user")
    public Object prCountByUser(@PathVariable String repo,
                                @RequestParam(required = false) Integer page) {
        log.info("pr count by user");
        log.info("pr page: " + String.valueOf(page));
        return service.prCountByUser(repo, page);
    }

    @ResponseJsonResult
    @GetMapping("/{repo}/pr-cnt/{dateValue}")
    public Object prCountByDate (@PathVariable String repo, @PathVariable String dateValue) {
        log.info("pr count by date");
        return service.prCountByDate(repo);
    }

    @ResponseJsonResult
    @GetMapping("/{repo}/commit-cnt/date")
    public Object commitCountByDate (@PathVariable String repo,
                                     @RequestParam String since,
                                     @RequestParam String until) {
        log.info("commit count by date");
        log.info(since);
        log.info(until);
        return service.commitCountByDate(repo, since, until);
    }
}
