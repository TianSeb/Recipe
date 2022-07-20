package com.tianseb.recipe.controllers;

import com.tianseb.recipe.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@Slf4j
public class IndexController {
    private final RecipeService recipeService;
    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
    @RequestMapping(value ="/",method = RequestMethod.GET)
    public String getIndexPage(Model model) {
        log.debug("I´m in the controller");
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}