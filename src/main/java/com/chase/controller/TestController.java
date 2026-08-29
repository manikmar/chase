package com.chase.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("/data")
    public String getData() {
        System.out.println("code form main feature commit");
        System.out.println("my changes form git repo $$$$$$$-->");
        System.out.println("my changes form intellij ------->");
        return "Get Data......!";
    }
}
