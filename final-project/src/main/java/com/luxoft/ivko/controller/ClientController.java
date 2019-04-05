package com.luxoft.ivko.controller;

import com.luxoft.ivko.service.ClientService;
import com.luxoft.ivko.web.dto.ClientViewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.regex.Pattern;

@Controller
public class ClientController {

    @Autowired
    @Qualifier("clientServiceImpl")
    private ClientService clientService;


    @GetMapping(value = {"/clients"})
    public ModelAndView showClients() {
        List<ClientViewDto> clients = clientService.getAllClients();
        ModelAndView model = new ModelAndView("showClients");
        model.addObject("clients", clients);
        return model;
    }

    @GetMapping("/clients/search")
    public ModelAndView getClientById(@RequestParam String id) {
        if (id.isEmpty() || !Pattern.matches("\\d+", id)) {
            return new ModelAndView("redirect:/clients");
        }
        return new ModelAndView("profile", "client", clientService.getClientById(Long.parseLong(id)));
    }

    @GetMapping("/clients/delete")
    public ModelAndView removeClientById(@RequestParam String id) {
        clientService.deleteClient(Long.parseLong(id));
        return new ModelAndView("redirect:/clients");
    }
}
