package com.mobigen.GithubApiProject.Config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class GithubApiToken {

    //final String token ="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";
    final String token = "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";

    public Map<String, String> accessToken() {

        Map<String, String> accessToken = new HashMap<>();

        accessToken.put("Access-Token", token);
        return accessToken;
    }
}