package com.luxoft.ivko.web.servlet;

import com.luxoft.ivko.service.ClientService;
import com.luxoft.ivko.service.impl.ClientServiceImpl;
import com.luxoft.ivko.web.dto.ClientCreateDto;
import com.luxoft.ivko.web.dto.ClientViewDto;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@WebServlet(name = "clientController", urlPatterns = "/clients")
public class ClientServlet extends HttpServlet {
    private ClientService service = new ClientServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id;
        HttpSession session = req.getSession(true);
        String idParam = req.getParameter("id");
        if (StringUtils.isNotEmpty(idParam)) {
            id = Long.valueOf(idParam);
            ClientViewDto client = service.getClientById(id);
            session.setAttribute("client", client);
            resp.sendRedirect("/profile.jsp");
        } else {
            showAllClients(req, resp, session);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ClientCreateDto clientCreateDto = extractClientFromRequest(req, "");
        service.registerClient(clientCreateDto);
        showAllClients(req, resp, req.getSession(true));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("saveList") != null) {
            updateClients(req);
        } else {
            ClientCreateDto client = extractClientFromRequest(req, "");
            service.updateClient(client);
        }
        showAllClients(req, resp, req.getSession(true));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ClientCreateDto clientCreateDto = extractClientFromRequest(req, "");
        service.deleteClient(clientCreateDto);
        showAllClients(req, resp, req.getSession(true));
    }


    private void updateClients(HttpServletRequest req) {
        List<ClientViewDto> allClients = service.getAllClients();
        Predicate<Pair<ClientViewDto, ClientCreateDto>> isClientChanged = getIsChangedPredicate();
        List<ClientCreateDto> changedClients = allClients
                .stream()
                .map(client -> new ImmutablePair<>(client, extractClientFromRequest(req, "_" + client.getId())))
                .filter(isClientChanged::test)
                .map(ImmutablePair::getRight)
                .collect(Collectors.toList());
        service.updateClients(changedClients);
    }

    private void showAllClients(HttpServletRequest req,
                                HttpServletResponse resp, HttpSession session) throws ServletException, IOException {
        HttpServletRequestWrapper wrapper = new HttpServletRequestWrapper(req) {
            @Override
            public String getMethod() {
                return "GET";
            }
        };
        List<ClientViewDto> clients = service.getAllClients();
        session.setAttribute("clients", clients);
        RequestDispatcher requestDispatcher = wrapper.getRequestDispatcher("/showClients.jsp");
        requestDispatcher.forward(wrapper, resp);
    }

    private Predicate<Pair<ClientViewDto, ClientCreateDto>> getIsChangedPredicate() {
        return (pair) -> {
            ClientViewDto origin = pair.getLeft();
            ClientCreateDto income = pair.getRight();
            return !(origin.getName().equals(income.getName())
                    && origin.getSurname().equals(income.getSurname())
                    && origin.getEmail().equals(income.getEmail())
                    && origin.getPhone().equals(income.getPhone())
                    && origin.getAge().equals(income.getAge()));
        };
    }

    private ClientCreateDto extractClientFromRequest(HttpServletRequest req, String suffix) {
        String idParam = req.getParameter("id" + suffix);
        String name = req.getParameter("name" + suffix);
        String surname = req.getParameter("surname" + suffix);
        String email = req.getParameter("email" + suffix);
        String password = req.getParameter("password" + suffix);
        String phone = req.getParameter("phone" + suffix);
        String age = req.getParameter("age" + suffix);
        Long id = null;
        if (StringUtils.isNotEmpty(idParam)) {
            id = Long.valueOf(idParam);
        }
        return new ClientCreateDto(id, name, surname, email, password, phone, age);
    }
}
