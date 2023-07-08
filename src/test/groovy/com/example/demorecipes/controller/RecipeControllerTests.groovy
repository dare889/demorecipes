package com.example.demorecipes.controller

import com.example.demorecipes.model.Recipe
import com.example.demorecipes.repository.RecipeRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.springframework.boot.test.context.SpringBootTest

import static org.junit.jupiter.api.Assertions.assertEquals
import static org.mockito.Mockito.*

@SpringBootTest
class RecipeControllerTests {
    @Mock
    private RecipeRepository recipeRepository

    @InjectMocks
    private RecipeController recipeController

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this)
    }

    /**
     * Tests the getAllRecipes() method of RecipeController.
     * It verifies that the method returns the expected list of recipes.
     */
    @Test
    void testGetAllRecipes() {
        // Prepare test data
        def recipe1 = new Recipe(id: 1L, name: "Recipe 1", description: "Description 1")
        def recipe2 = new Recipe(id: 2L, name: "Recipe 2", description: "Description 2")
        def recipeList = [recipe1, recipe2]

        // Mock the behavior of the recipeRepository
        when(recipeRepository.findAll()).thenReturn(recipeList)

        // Perform the test
        def result = recipeController.getAllRecipes()

        // Verify the result
        assertEquals(recipeList, result)
        verify(recipeRepository, times(1)).findAll()
        verifyNoMoreInteractions(recipeRepository)
    }

    /**
     * Tests the getRecipeById() method of RecipeController.
     * It verifies that the method retrieves the correct recipe when provided with a valid ID.
     */
    @Test
    void testGetRecipeById() {
        // Prepare test data
        def recipe = new Recipe(id: 1L, name: "Recipe 1", description: "Description 1")

        // Mock the behavior of the recipeRepository
        when(recipeRepository.findById(1L)).thenReturn(Optional.of(recipe))

        // Perform the test
        def result = recipeController.getRecipeById(1L)

        // Verify the result
        assertEquals(recipe, result)
        verify(recipeRepository, times(1)).findById(1L)
        verifyNoMoreInteractions(recipeRepository)
    }

    /**
     * Tests the createRecipe() method of RecipeController.
     * It confirms that the method properly creates and saves a new recipe.
     */
    @Test
    void testCreateRecipe() {
        // Prepare test data
        def recipe = new Recipe(id: 1L, name: "Recipe 1", description: "Description 1")

        // Mock the behavior of the recipeRepository
        when(recipeRepository.save(recipe)).thenReturn(recipe)

        // Perform the test
        def result = recipeController.createRecipe(recipe)

        // Verify the result
        assertEquals(recipe, result)
        verify(recipeRepository, times(1)).save(recipe)
        verifyNoMoreInteractions(recipeRepository)
    }

    /**
     * Tests the updateRecipe() method of RecipeController.
     * It verifies that the method updates an existing recipe with the provided data.
     */
    @Test
    void testUpdateRecipe() {
        // Prepare test data
        def existingRecipe = new Recipe(id: 1L, name: "Recipe 1", description: "Description 1")
        def updatedRecipe = new Recipe(id: 1L, name: "Updated Recipe", description: "Updated Description")

        // Mock the behavior of the recipeRepository
        when(recipeRepository.findById(1L)).thenReturn(Optional.of(existingRecipe))
        when(recipeRepository.save(existingRecipe)).thenReturn(existingRecipe)

        // Perform the test
        def result = recipeController.updateRecipe(1L, updatedRecipe)

        // Verify the result
        assertEquals(existingRecipe, result)
        assertEquals(updatedRecipe.name, existingRecipe.name)
        assertEquals(updatedRecipe.description, existingRecipe.description)
        verify(recipeRepository, times(1)).findById(1L)
        verify(recipeRepository, times(1)).save(existingRecipe)
        verifyNoMoreInteractions(recipeRepository)
    }

    /**
     * Tests the deleteRecipe() method of RecipeController.
     * It verifies that the method correctly deletes a recipe by its ID.
     */
    @Test
    void testDeleteRecipe() {
        // Perform the test
        recipeController.deleteRecipe(1L)

        // Verify the interaction
        verify(recipeRepository, times(1)).deleteById(1L)
        verifyNoMoreInteractions(recipeRepository)
    }
}
