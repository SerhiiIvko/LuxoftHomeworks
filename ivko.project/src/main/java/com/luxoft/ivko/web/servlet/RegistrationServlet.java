package com.luxoft.ivko.web.servlet;

import com.luxoft.ivko.service.ClientService;
import com.luxoft.ivko.service.impl.ClientServiceImpl;
import com.luxoft.ivko.web.dto.ClientCreateDto;
import com.luxoft.ivko.web.dto.ClientViewDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "registrationServlet", urlPatterns = "/register")
public class RegistrationServlet extends HttpServlet {

    private ClientService clientService = new ClientServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ClientCreateDto clientCreateDto = extractClientFromRequest(req);
        ClientViewDto client = clientService.registerClient(clientCreateDto);
        HttpSession session = req.getSession(true);
        session.setAttribute("client", client);
        resp.sendRedirect("/show.jsp");
    }

    private ClientCreateDto extractClientFromRequest(HttpServletRequest req) {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");
        String ageParam = req.getParameter("age");
        return new ClientCreateDto(name, surname, email, password, phone, ageParam);
    }
}