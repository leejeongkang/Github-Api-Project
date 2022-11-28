package com.mobigen.GithubApiProject.Config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class GithubApiToken {

    final String token ="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";

    public Map<String, String> accessToken() {

        Map<String, String> accessToken = new HashMap<>();

        accessToken.put("Access-Token", token);
        return accessToken;
    }
}