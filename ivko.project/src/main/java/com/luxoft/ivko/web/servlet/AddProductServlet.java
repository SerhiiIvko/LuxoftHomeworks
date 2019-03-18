package com.luxoft.ivko.web.servlet;

import com.luxoft.ivko.service.ProductService;
import com.luxoft.ivko.service.impl.ProductServiceImpl;
import com.luxoft.ivko.web.dto.ProductCreateDto;
import com.luxoft.ivko.web.dto.ProductViewDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "addProductServlet", urlPatterns = "/addProduct")
public class AddProductServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductCreateDto createDto = extractProductFromRequest(req);
        ProductViewDto product = productService.registerProduct(createDto);
        HttpSession session = req.getSession(true);
        session.setAttribute("product", product);
        resp.sendRedirect("/products");
    }

    private ProductCreateDto extractProductFromRequest(HttpServletRequest req) {
        String name = req.getParameter("name");
        String productType = req.getParameter("productType");
        String price = req.getParameter("price");
        return new ProductCreateDto(name, productType, price);
    }
}
