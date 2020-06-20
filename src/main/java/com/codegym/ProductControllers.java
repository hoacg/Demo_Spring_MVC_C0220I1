package com.codegym;

import com.codegym.models.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductControllers {

    @GetMapping("/add")
    public ModelAndView getProductForm() {
        Product product = new Product();

        ModelAndView mv = new ModelAndView("product-form");
        mv.addObject("product", product);
        return mv;
    }

    @GetMapping("/edit")
    public String editProductForm(Model model) {
        Product product = new Product();
        product.setTitle("Samsung");
        product.setDescription("S20+");


        model.addAttribute("product", product);

        return "product-form";
    }

    @ModelAttribute("productTypes")
    public List<String> getProductTypes() {
        List<String> types = new ArrayList<>();

        types.add("Điện thoại");
        types.add("Laptop");
        types.add("Khác");

        return types;
    }

    @PostMapping("")
    public String addProduct(@ModelAttribute Product product) {

        return "product-form";
    }

}
