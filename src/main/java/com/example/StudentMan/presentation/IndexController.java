package com.example.StudentMan.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {


    @GetMapping("/")
    public String getIndex()
    {
        return "index";
    }

    @GetMapping("EnterNameStudent")
    public String getStudentPage()
    {
        return "EnterNameStudent";
    }
}