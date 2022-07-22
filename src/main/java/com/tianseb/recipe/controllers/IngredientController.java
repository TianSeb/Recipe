package com.tianseb.recipe.controllers;

import com.tianseb.recipe.commands.RecipeCommand;
import com.tianseb.recipe.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class IngredientController {
    RecipeService recipeService;

    public IngredientController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    @RequestMapping("recipe/{id}/ingredients")
    public String listIngredients(@PathVariable Long id, Model model){
        log.debug("Getting ingredients list for recipe id: " + id);
        //use command object, to avoid lazy errors thymeleaf
        model.addAttribute("recipe",recipeService.findCommandById(id));
        return "recipe/ingredient/list";
    }
}
