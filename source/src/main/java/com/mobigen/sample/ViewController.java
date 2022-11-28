package com.mobigen.sample;

import com.mobigen.framework.security.SessionManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class ViewController {
    private final SessionManager sessionManager;
//    @GetMapping("/")
//    public String index() {
//        User user = sessionManager.getUser();
//        if (null == user) {
//            return "index";
//        }
//        return "app";
//    }
//
//    @GetMapping("/app")
//    public String app() {
//        return "app";
//    }
}
