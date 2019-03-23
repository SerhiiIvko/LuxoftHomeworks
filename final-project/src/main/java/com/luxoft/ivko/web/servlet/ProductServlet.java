package com.luxoft.ivko.web.servlet;

import com.luxoft.ivko.service.ProductService;
import com.luxoft.ivko.service.impl.ProductServiceImpl;
import com.luxoft.ivko.web.dto.ProductCreateDto;
import com.luxoft.ivko.web.dto.ProductViewDto;
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

@WebServlet(name = "productController", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id;
        HttpSession session = req.getSession(true);
        String idParam = req.getParameter("id");
        if (StringUtils.isNotEmpty(idParam)) {
            id = Long.valueOf(idParam);
            ProductViewDto product = productService.getProductById(id);
            session.setAttribute("product", product);
            resp.sendRedirect("/product.jsp");
        } else {
            showAllProducts(req, resp, session);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductCreateDto productCreateDto = extractProductFromRequest(req, "");
        productService.registerProduct(productCreateDto);
        showAllProducts(req, resp, req.getSession(true));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("saveList") != null) {
            updateProducts(req);
        } else {
            ProductCreateDto product = extractProductFromRequest(req, "");
            productService.updateProduct(product);
        }
        showAllProducts(req, resp, req.getSession(true));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductCreateDto productCreateDto = extractProductFromRequest(req, "");
        productService.deleteProduct(productCreateDto);
        showAllProducts(req, resp, req.getSession(true));
    }


    private void updateProducts(HttpServletRequest req) {
        List<ProductViewDto> allProducts = productService.getAllProducts();
        Predicate<Pair<ProductViewDto, ProductCreateDto>> isProductChanged = getIsChangedPredicate();
        List<ProductCreateDto> changedClients = allProducts
                .stream()
                .map(product -> new ImmutablePair<>(product, extractProductFromRequest(req, "_" + product.getId())))
                .filter(isProductChanged::test)
                .map(ImmutablePair::getRight)
                .collect(Collectors.toList());
        productService.updateProducts(changedClients);
    }

    private void showAllProducts(HttpServletRequest req,
                                 HttpServletResponse resp, HttpSession session) throws ServletException, IOException {
        HttpServletRequestWrapper wrapper = new HttpServletRequestWrapper(req) {
            @Override
            public String getMethod() {
                return "GET";
            }
        };
        List<ProductViewDto> products = productService.getAllProducts();
        session.setAttribute("products", products);
        RequestDispatcher requestDispatcher = wrapper.getRequestDispatcher("/showProducts.jsp");
        requestDispatcher.forward(wrapper, resp);
    }

    private Predicate<Pair<ProductViewDto, ProductCreateDto>> getIsChangedPredicate() {
        return (pair) -> {
            ProductViewDto origin = pair.getLeft();
            ProductCreateDto income = pair.getRight();
            return !(origin.getName().equals(income.getName())
                    && origin.getProductType().equals(income.getProductType())
                    && origin.getPrice().equals(income.getPrice()));
        };
    }

    private ProductCreateDto extractProductFromRequest(HttpServletRequest req, String suffix) {
        String idParam = req.getParameter("id" + suffix);
        String name = req.getParameter("name" + suffix);
        String productType = req.getParameter("productType" + suffix);
        String price = req.getParameter("price" + suffix);
        Long id = null;
        if (StringUtils.isNotEmpty(idParam)) {
            id = Long.valueOf(idParam);
        }
        return new ProductCreateDto(id, name, productType, price);
    }
}
