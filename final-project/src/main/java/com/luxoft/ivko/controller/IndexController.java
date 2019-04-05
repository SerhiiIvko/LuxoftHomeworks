package com.luxoft.ivko.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @GetMapping(value = {"/", "index.jsp"})
    public ModelAndView index() {
        return new ModelAndView("http://localhost:8080/");
    }
}