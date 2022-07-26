package com.tianseb.recipe.service;

import com.tianseb.recipe.commands.IngredientCommand;
import com.tianseb.recipe.converters.IngredientToIngredientCommand;
import com.tianseb.recipe.converters.UnitOfMeasureToUnitOfMeasureCommand;
import com.tianseb.recipe.domain.Ingredient;
import com.tianseb.recipe.domain.Recipe;
import com.tianseb.recipe.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class IngredientServiceImplTest {
    @Mock
    RecipeRepository recipeRepository;
    IngredientToIngredientCommand ingredientToIngredientCommand;
    IngredientService ingredientService;

    //init converters
    public IngredientServiceImplTest() {
        this.ingredientToIngredientCommand = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
    }

    @BeforeEach
    void setUp() {
        ingredientService = new IngredientServiceImpl(ingredientToIngredientCommand, recipeRepository);
    }

    @Test
    void findByRecipeIdAndIngredientIdh() {
    }

    @Test
    void findByRecipeIdAndIngredientIdHappyPath() {
        //given
        Recipe recipe1 = new Recipe();
        recipe1.setId(1L);

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setId(1L);
        Ingredient ingredient2 = new Ingredient();
        ingredient1.setId(1L);
        Ingredient ingredient3 = new Ingredient();
        ingredient1.setId(3L);

        recipe1.addIngredient(ingredient1);
        recipe1.addIngredient(ingredient2);
        recipe1.addIngredient(ingredient3);
        Optional<Recipe> recipeOptional = Optional.of(recipe1);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);
        //when
        IngredientCommand ingredientCommand = ingredientService.findByRecipeIdAndIngredientId(1L,3L);
        //then
        assertEquals(Long.valueOf(3L),ingredientCommand.getId());
        assertEquals(Long.valueOf(1L),ingredientCommand.getRecipeId());
        verify(recipeRepository,times(1)).findById(anyLong());

    }
}