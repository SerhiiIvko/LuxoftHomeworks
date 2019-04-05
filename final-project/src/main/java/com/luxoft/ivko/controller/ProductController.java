package com.luxoft.ivko.controller;

import com.luxoft.ivko.service.ProductService;
import com.luxoft.ivko.web.dto.ProductViewDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.regex.Pattern;

@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = {"/products"})
    public ModelAndView showProducts() {
        List<ProductViewDto> products = productService.getAllProducts();
        ModelAndView map = new ModelAndView("showProducts");
        map.addObject("products", products);
        return map;
    }

    @GetMapping("/products/search")
    public ModelAndView getProductById(@RequestParam String id) {
        if (id.isEmpty() || !Pattern.matches("\\d+", id)) {
            return new ModelAndView("redirect:/products");
        }
        return new ModelAndView("product", "product", productService.getProductById(Long.parseLong(id)));
    }

    @GetMapping("/products/delete")
    public ModelAndView removeProductById(@RequestParam String id) {
        productService.deleteProduct(Long.parseLong(id));
        return new ModelAndView("redirect:/products");
    }
}
