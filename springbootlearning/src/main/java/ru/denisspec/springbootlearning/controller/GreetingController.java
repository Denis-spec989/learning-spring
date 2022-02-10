package ru.denisspec.springbootlearning.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {
    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name = "name",required = false,defaultValue = "pilgrim") String name,
            Map<String,Object> model)
    {
        model.put("name",name);
        return "greeting";
    }
    @GetMapping
    public String main(Map<String,Object> model)
    {
        model.put("something","Hey");
        return "main";
    }
}
