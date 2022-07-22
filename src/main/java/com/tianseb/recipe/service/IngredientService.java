package com.tianseb.recipe.service;

import com.tianseb.recipe.commands.IngredientCommand;

public interface IngredientService {
     IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);
}
