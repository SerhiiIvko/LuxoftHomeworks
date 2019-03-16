package com.luxoft.ivko.web.servlet;

import com.luxoft.ivko.dao.ClientDao;
import com.luxoft.ivko.domain.Client;
import com.luxoft.ivko.service.ClientService;
import com.luxoft.ivko.service.impl.ClientServiceImpl;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "clientController", urlPatterns = "/clients")
public class ClientServlet extends HttpServlet {
    private ClientDao clientDao;
    private ClientService service = new ClientServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<h1>clients:</h1>" + "<br>");
        List<Client> clients = clientDao.getAllClients();
        writer.println(clients.toString());
        service.showAllClients();
//        req.getRequestDispatcher("/allClients.jsp").forward(req, resp);
//        service.showAllClients();
//
//        session.setAttribute("clients", clients);
//        for(Client client:clientDao.getAllClients()){
//            writer.println(client);
//            writer.println("<br>");
//        }

//        Long id;
//        HttpSession session = req.getSession(true);
//        String idParam = req.getParameter("id");
//        if (StringUtils.isNotEmpty(idParam)) {
//            id = Long.valueOf(idParam);
//            Client client = clientDao.getClientById(id);
//            session.setAttribute("client", client);
//            resp.sendRedirect("/profile.html");
//        } else {
//            showAllClients(req, resp);
//        }
    }

    private void showAllClients(HttpServletRequest req,
                                HttpServletResponse resp) throws ServletException, IOException {
        HttpServletRequestWrapper wrapper = new HttpServletRequestWrapper(req) {
            @Override
            public String getMethod() {
                return "GET";
            }
        };

        RequestDispatcher requestDispatcher = wrapper.getRequestDispatcher("/allClients.jsp");
        requestDispatcher.forward(wrapper, resp);
    }
}
