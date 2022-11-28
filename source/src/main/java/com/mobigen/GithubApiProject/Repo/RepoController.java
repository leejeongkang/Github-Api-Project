package com.mobigen.GithubApiProject.Repo;

import com.mobigen.framework.result.annotation.ResponseJsonResult;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @GetMapping("/{repo}/branch-list")
    public Object branchList(@PathVariable String repo) {

        log.info("branch list");
        return service.branchList(repo);
    }

    @ResponseJsonResult
    @GetMapping("/{repo}/commit-cnt")
    public Object commitCnt(@PathVariable String repo) {

        log.info("commit count");
        return service.commitCnt(repo);
    }

    @ResponseJsonResult
    @GetMapping("/{repo}/pr-cnt")
    public Object prCnt(@PathVariable String repo) {

        log.info("pr count");
        return service.prCnt(repo);
    }

    @ResponseJsonResult
    @GetMapping("/{repo}/user-cnt")
    public Object userCnt(@PathVariable String repo) {

        log.info("user count");
        return service.userCnt(repo);
    }

    @ResponseJsonResult
    @GetMapping("/{repo}branch-cnt")
    public Object branchCnt(@PathVariable String repo){

        log.info("branch count");
        return service.branchCnt(repo);
    }

    @ResponseJsonResult
    @GetMapping("/{repo}/commits/{user}")
    public Object commitCntByUser(@PathVariable String repo,
                                  @PathVariable String user) {
        log.info("commit by user count");
        return service.commitCntByUser(repo, user);
    }

    @ResponseJsonResult
    @GetMapping("/{repo}/pr/{user}")
    public Object prCntByUser(@PathVariable String repo,
                              @PathVariable String user) {
        log.info("pr count by user");
        return service.prCntByUser(repo, user);
    }

    @ResponseJsonResult
    @GetMapping("/{repo}/pr/{datePick}")
    public Object prCntByDate (@PathVariable String repo,
                               @PathVariable String datePick) {
        log.info("pr count by date");
        return service.prCntByDate(repo, datePick);
    }

    @ResponseJsonResult
    @GetMapping("/{repo}/commits/{datePick}")
    public Object commitCntByDate (@PathVariable String repo,
                                   @PathVariable String datePick) {
        log.info("commit count by date");
        return service.commitCntByDate(repo, datePick);
    }
}
