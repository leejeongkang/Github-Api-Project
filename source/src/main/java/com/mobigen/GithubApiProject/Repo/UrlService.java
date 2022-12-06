package com.mobigen.GithubApiProject.Repo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UrlService {
    static final String owner = "mobigen";

    static final String githubURL = "https://api.github.com/repos/" + owner + "/";
    static final String repoListURL = "https://api.github.com/orgs/" + owner + "/repos";
    static final String branchListURL = "/branches";
    static final String commitCountURL = "/commits?per_page=100";
    static final String prCountURL = "/pulls?state=all&per_page=100";
    static final String userCountURL = "/contributors?state=all";
    static final String branchCountURL = "/branches?state=all";
    static final String commitCountByUserURL = "/commits?state=all";
    static final String prCountByUserURL = "/pulls?state=all";
    static final String commitCountByDateURL = "/commits?state=all";
    static final String prCountByDateURL = "/pulls?state=all";

    public String getRepoListURL() {
        return repoListURL;
    }
    public String getBranchListURL(String repo) {
        return githubURL + repo + branchListURL;
    }
    public String getCommitCountURL(String repo) {
        return githubURL + repo + commitCountURL;
    }
    public String getPrCountURL(String repo) {
        return githubURL + repo + prCountURL;
    }
    public String getUserCountURL(String repo) {
        return githubURL + repo + userCountURL;
    }
    public String getBranchCountURL(String repo) {
        return githubURL + repo + branchCountURL;
    }
    public String getCommitCountByUserURL(String repo) {
        return githubURL + repo + commitCountByUserURL;
    }
    public String getPrCountByUserURL(String repo) {
        return githubURL + repo + prCountByUserURL;
    }
    public String getCommitCountByDateURL(String repo) {
        return githubURL + repo + commitCountByDateURL;
    }
    public String getPrCountByDateURL(String repo) {
        return githubURL + repo + prCountByDateURL;
    }
}
