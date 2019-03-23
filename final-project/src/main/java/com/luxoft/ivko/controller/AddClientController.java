package com.luxoft.ivko.controller;

import com.luxoft.ivko.model.Client;
import com.luxoft.ivko.service.ClientService;
import com.luxoft.ivko.web.dto.ClientCreateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AddClientController {
    @Autowired
    public ClientService clientService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("/createClient.jsp");
        mav.addObject("client", new Client());
        return mav;
    }

    @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
    public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
                                @ModelAttribute("user") ClientCreateDto client) {
        clientService.registerClient(client);
        return new ModelAndView("welcome", "name", client.getName());
    }
}
