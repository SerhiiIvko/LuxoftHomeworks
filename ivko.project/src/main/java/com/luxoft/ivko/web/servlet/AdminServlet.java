//package com.luxoft.ivko.web.servlet;
//
//import org.apache.commons.lang3.StringUtils;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@WebServlet(name = "adminController", urlPatterns = "/admin/")
//public class AdminServlet extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//
//
////        Long id;
////        HttpSession session = req.getSession(true);
////        String idParam = req.getParameter("id");
////        if (StringUtils.isNotEmpty(idParam)) {
////            id = Long.valueOf(idParam);
////            ManagerViewDto manager = managerService.getManagerById(id);
////            session.setAttribute("manager", manager);
////            resp.sendRedirect("/profile.jsp");
////        } else {
////            showAllManagers(req, resp, session);
////        }
//    }
//}
