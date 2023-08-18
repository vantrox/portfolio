package com.test.portfolioback.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Robson J Silva <vantrox@yahoo.com.br>
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String main(Model model) throws Exception {
        model.addAttribute("content", "portfolio");
        return "index"; //view
    }
}
