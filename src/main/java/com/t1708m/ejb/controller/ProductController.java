package com.t1708m.ejb.controller;

import com.t1708m.ejb.entity.Product;
import com.t1708m.ejb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("products", new Product());
        return "products/form";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String store(@Valid Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/products/form";
        }
        productService.create(product);
        return "redirect:/products";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("products", productService.getList(1, 10));
        return "/products/list";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getDetail(@PathVariable int id, Model model) {
        model.addAttribute("flower", productService.getDetail(id));
        return "/products/detail";
    }
}
