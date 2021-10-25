package com.example.scopedemo.controllers;

import com.example.scopedemo.models.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController {

    //Global scope
    private int counter = 0;

    @GetMapping("/")
    public String pageController(WebRequest request, Model model) {
        counter++;
        model.addAttribute("counter", counter);
        List<Product> basket = (ArrayList<Product>) request.getAttribute("basket", WebRequest.SCOPE_SESSION);
        return "main";
    }

    @GetMapping("/newProduct")
    public String addProduct(Model model) {
        model.addAttribute("products", null);
        return "productForm";
    }

    @GetMapping("/newProduct2")
    public String addProduct2(Model model) {
        model.addAttribute("product", new Product());
        return "productForm2";
    }

    @PostMapping(value = "/saveProduct")
    public String saveStudent(WebRequest request, @ModelAttribute Product product, Model model) {
        //String param1 = request.getParameter("description");
        //String param2 = request.getParameter("quantity");
        //Product product = new Product(param1, Integer.parseInt(param2));
        List<Product> basket = (ArrayList<Product>) request.getAttribute("basket", WebRequest.SCOPE_SESSION);
        //NY
        if (basket == null) {
            basket = new ArrayList<>();
        }
        basket.add(product);
        request.setAttribute("basket", basket, WebRequest.SCOPE_SESSION);
        return"redirect:/";
    }

    @PostMapping("/addToBasket")
    public String bookList(WebRequest request, HttpSession session) {
        String param1 = request.getParameter("description");
        String param2 = request.getParameter("quantity");
        Product product = new Product(param1, Integer.parseInt(param2));
        List<Product> basket = (ArrayList<Product>) request.getAttribute("basket", WebRequest.SCOPE_SESSION);
        if (basket == null) {
            basket = new ArrayList<>();
        }
        basket.add(product);
        request.setAttribute("basket", basket, WebRequest.SCOPE_SESSION);
        request.
        return"redirect:/";
    }
}
