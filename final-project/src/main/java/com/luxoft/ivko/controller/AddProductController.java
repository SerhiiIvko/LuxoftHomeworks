package com.luxoft.ivko.controller;

import com.luxoft.ivko.service.ProductService;
import com.luxoft.ivko.web.dto.ProductCreateDto;
import com.luxoft.ivko.web.dto.ProductViewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddProductController {

    @Autowired
    @Qualifier("productServiceImpl")
    private ProductService productService;

    @GetMapping(value = "/addProduct")
    public ModelAndView registration() {
        return new ModelAndView("/addProduct");
    }

    @PostMapping(value = "/addProduct")
    public ModelAndView registerClient(String name,
                                       String productType,
                                       String price) {
        ProductCreateDto createDto = new ProductCreateDto(name, productType, price);
        ModelAndView model = new ModelAndView("redirect:/products");
        ProductViewDto viewDto = productService.registerProduct(createDto);
        model.addObject(viewDto);
        return model;
    }
}
