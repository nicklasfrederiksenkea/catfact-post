package com.example.demo.controllers;

import com.example.demo.models.CatFact;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class CatFactController {
    CatFact catFactToDisplay = new CatFact("Hello World");

    @GetMapping("/")
    public String index(Model catFactModel){
        catFactModel.addAttribute("catFactToDisplay",catFactToDisplay);
        return "index";
    }

    @PostMapping("/postCatFact")
    public String postCatFact(WebRequest dataFromForm){
        CatFact catFactFromForm = new CatFact(dataFromForm.getParameter("catfact"));
        catFactToDisplay = catFactFromForm;
        return "redirect:/";
    }
}
