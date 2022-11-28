package com.mobigen.sample;

import com.mobigen.framework.iris.IRISProperties;
import com.mobigen.framework.iris.User;
import com.mobigen.framework.result.annotation.ResponseJsonResult;
import com.mobigen.framework.security.SessionManager;
import com.mobigen.framework.utility.RSA;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Slf4j
@RequestMapping("/api")
@Controller
@AllArgsConstructor
public class SampleController {
    private final IRISProperties properties;
    private final SampleService sampleService;
    private final SessionManager sessionManager;

    @ResponseJsonResult
    @GetMapping("/authenticate/key")
    public Object publicKey(HttpServletRequest request) throws Exception {
        return sessionManager.generateRSAPublicKey(request);
    }

    @ResponseJsonResult
    @PostMapping("/authenticate")
    public Object authenticate(@RequestBody Map<String, String> param, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = param.get("username");
        String password = sessionManager.decryptRSAString(request, (String)param.get("password"));

        return sampleService.authenticate(request, response, username, password);
    }

    @ResponseJsonResult
    @GetMapping("/user")
    public Object user(@AuthenticationPrincipal User user) {
        return user.getUsername();
    }

    @ResponseJsonResult
    @GetMapping("/message")
    public Object message() {
        return sampleService.getMessage();
    }

    @ResponseJsonResult
    @GetMapping("/user/{username}")
    public Object getUser(@PathVariable String username) throws Exception {
        return sampleService.getUser(username);
    }

    @ResponseJsonResult
    @GetMapping("/sample-images")
    public Object getSampleImages(int count) throws Exception {
        return sampleService.getSampleImages(count);
    }

    @ResponseJsonResult
    @GetMapping("/csrf-token")
    public Object getCsrfToken() throws Exception {
        return true;
    }
}