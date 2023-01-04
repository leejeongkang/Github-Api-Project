package com.mobigen.githubApiProject.config;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class GithubApiToken {

    //final String token ="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";
    //final String token = "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";
    //final String token ="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";
    //final String token = "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";

    final String token = "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";
    public Map<String, String> accessToken() {

        Map<String, String> accessToken = new HashMap<>();

        accessToken.put("Access-Token", token);
        return accessToken;
    }
}