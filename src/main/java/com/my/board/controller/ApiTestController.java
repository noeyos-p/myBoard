package com.my.board.controller;

import com.my.board.dto.LoginDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApiTestController {
    @PostMapping("/apiTest")
    @ResponseBody
    public LoginDto getTest() {
        return new LoginDto("noeyos", "1111");
    }
}

