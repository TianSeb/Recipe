package com.tianseb.recipe.service;

import com.tianseb.recipe.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
}
