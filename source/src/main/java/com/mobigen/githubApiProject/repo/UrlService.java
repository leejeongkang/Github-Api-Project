package com.mobigen.githubApiProject.repo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UrlService {
    static final String OWNER = "mobigen";
    static final String GITHUB_URL = "https://api.github.com/repos/" + OWNER + "/";
    static final String REPO_LIST_URL = "https://api.github.com/orgs/" + OWNER + "/repos?per_page=100";
    static final String BRANCH_LIST_URL = "/branches";
    static final String COMMIT_COUNT_URL = "/commits";
    static final String PR_COUNT_URL = "/pulls?state=all&per_page=100";
    static final String USER_COUNT_URL = "/contributors?state=all";
    static final String BRANCH_COUNT_URL = "/branches?state=all";
    static final String COMMIT_COUNT_BY_USER_URL = "/commits";
    static final String PR_COUNT_BY_USER_URL = "/pulls?state=all";
    static final String COMMIT_COUNT_BY_DATE_URL = "/commits";
    static final String PR_COUNT_BY_DATE_URL = "/pulls?state=all";

    public String getRepoListURL() {
        return REPO_LIST_URL;
    }
    public String getBranchListURL(String repo) {
        return GITHUB_URL + repo + BRANCH_LIST_URL;
    }
    public String getCommitCountURL(String repo) {
        return GITHUB_URL + repo + COMMIT_COUNT_URL;
    }
    public String getPrCountURL(String repo) {
        return GITHUB_URL + repo + PR_COUNT_URL;
    }
    public String getUserCountURL(String repo) {
        return GITHUB_URL + repo + USER_COUNT_URL;
    }
    public String getBranchCountURL(String repo) {
        return GITHUB_URL + repo + BRANCH_COUNT_URL;
    }
    public String getCommitCountByUserURL(String repo) {
        return GITHUB_URL + repo + COMMIT_COUNT_BY_USER_URL;
    }
    public String getPrCountByUserURL(String repo) {
        return GITHUB_URL + repo + PR_COUNT_BY_USER_URL;
    }
    public String getCommitCountByDateURL(String repo) {
        return GITHUB_URL + repo + COMMIT_COUNT_BY_DATE_URL;
    }
    public String getPrCountByDateURL(String repo) {
        return GITHUB_URL + repo + PR_COUNT_BY_DATE_URL;
    }
}
