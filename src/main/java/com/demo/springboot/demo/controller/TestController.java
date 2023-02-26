package com.demo.springboot.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @RequestMapping("/test")
    @ResponseBody
    public ResponseEntity<String> function () {
        return ResponseEntity.ok("Hello World From Test Controller un cambio 123");
    }
}
