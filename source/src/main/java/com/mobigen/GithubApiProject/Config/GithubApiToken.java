package com.mobigen.GithubApiProject.Config;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class GithubApiToken {

    //final String token ="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";
    //final String token = "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";
    final String token ="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";
    public Map<String, String> accessToken() {

        Map<String, String> accessToken = new HashMap<>();

        accessToken.put("Access-Token", token);
        return accessToken;
    }
}