/*
package com.makeup.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/login")
public class KakaoLoginController {

    @Value("${client_id}")
    private String client_id;

    @Value("${redirect_uri}")
    private String redirect_uri;

    @GetMapping("/page")
    public String loginPage(Model model) {
        String location = "https://kauth.kakao.com/oauth/authorize?response_type=code&client_id="+client_id+"&redirect_uri=" +redirect_uri;
        model.addAttribute("location", location);

        return "login";
    }

}
*/