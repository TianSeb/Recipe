package com.tianseb.recipe.service;

import com.tianseb.recipe.converters.RecipeCommandToRecipe;
import com.tianseb.recipe.converters.RecipeToRecipeCommand;
import com.tianseb.recipe.domain.Recipe;
import com.tianseb.recipe.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class RecipeServiceImplTest {
    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;
    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;
    @Mock
    RecipeRepository recipeRepository;
    @InjectMocks
    RecipeServiceImpl recipeService;
    @BeforeEach
    void setUp() throws Exception {
    }
    @Test
    void getRecipes() throws Exception {
        Recipe recipe = new Recipe();
        HashSet recipesData = new HashSet<>();
        Mockito.when(recipeRepository.findAll()).thenReturn(recipesData);

        Set<Recipe> recipes = recipeService.getRecipes();
        assertEquals(recipes.size(),0);
        verify(recipeRepository,Mockito.times(1)).findAll();
    }

    @Test
    void testDeleteById() throws Exception {
        Long idToDelete = 2L;
        recipeService.deleteById(idToDelete);

        verify(recipeRepository,times(1)).deleteById(anyLong());
    }
}