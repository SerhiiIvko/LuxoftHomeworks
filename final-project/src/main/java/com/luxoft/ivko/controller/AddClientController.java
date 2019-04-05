package com.luxoft.ivko.controller;

import com.luxoft.ivko.service.ClientService;
import com.luxoft.ivko.web.dto.ClientCreateDto;
import com.luxoft.ivko.web.dto.ClientViewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddClientController {

    @Autowired
    @Qualifier("clientServiceImpl")
    private ClientService clientService;

    @GetMapping(value = "/register")
    public ModelAndView registration() {
        return new ModelAndView("createClient");
    }

    @PostMapping(value = "/register")
    public ModelAndView registerClient(String name,
                                       String surname,
                                       String email,
                                       String password,
                                       String phone,
                                       String age) {
        ClientCreateDto createDto = new ClientCreateDto(name, surname, email, password, phone, age);
        ModelAndView model = new ModelAndView("redirect:/clients");
        ClientViewDto viewDto = clientService.registerClient(createDto);
        model.addObject(viewDto);
        return model;
    }
}
