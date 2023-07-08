package com.example.demorecipes.repository

import com.example.demorecipes.model.Recipe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.boot.test.context.SpringBootTest

import static org.mockito.Mockito.*

@SpringBootTest
@ExtendWith(MockitoExtension)
class RecipeRepositoryTests {
    @Mock
    private RecipeRepository recipeRepository

    /**
     * Tests the findAll() method of RecipeRepository.
     * It verifies that the method returns the expected list of recipes.
     */
    @Test
    void testFindAll() {
        // Prepare test data
        def recipe1 = new Recipe(id: 1L, name: "Recipe 1", description: "Description 1")
        def recipe2 = new Recipe(id: 2L, name: "Recipe 2", description: "Description 2")
        def recipeList = [recipe1, recipe2]

        // Mock the behavior of the recipeRepository
        when(recipeRepository.findAll()).thenReturn(recipeList)

        // Perform the test
        def result = recipeRepository.findAll()

        // Verify the result
        assert result == recipeList
        verify(recipeRepository, times(1)).findAll()
        verifyNoMoreInteractions(recipeRepository)
    }

    /**
     * Tests the findById() method of RecipeRepository.
     * It verifies that the method retrieves the correct recipe when provided with a valid ID.
     */
    @Test
    void testFindById() {
        // Prepare test data
        def recipe = new Recipe(id: 1L, name: "Recipe 1", description: "Description 1")

        // Mock the behavior of the recipeRepository
        when(recipeRepository.findById(1L)).thenReturn(Optional.of(recipe))

        // Perform the test
        def result = recipeRepository.findById(1L)

        // Verify the result
        assert result.isPresent()
        assert result.get() == recipe
        verify(recipeRepository, times(1)).findById(1L)
        verifyNoMoreInteractions(recipeRepository)
    }

    /**
     * Tests the save() method of RecipeRepository.
     * It confirms that the method properly saves a recipe and returns the saved instance.
     */
    @Test
    void testSave() {
        // Prepare test data
        def recipe = new Recipe(id: 1L, name: "Recipe 1", description: "Description 1")

        // Mock the behavior of the recipeRepository
        when(recipeRepository.save(recipe)).thenReturn(recipe)

        // Perform the test
        def result = recipeRepository.save(recipe)

        // Verify the result
        assert result == recipe
        verify(recipeRepository, times(1)).save(recipe)
        verifyNoMoreInteractions(recipeRepository)
    }

    /**
     * Tests the deleteById() method of RecipeRepository.
     * It validates that the method correctly interacts with the repository when deleting a recipe by ID.
     */
    @Test
    void testDeleteById() {
        // Perform the test
        recipeRepository.deleteById(1L)

        // Verify the interaction
        verify(recipeRepository, times(1)).deleteById(1L)
        verifyNoMoreInteractions(recipeRepository)
    }

}
