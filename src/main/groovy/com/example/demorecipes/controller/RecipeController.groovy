package com.example.demorecipes.controller

import com.example.demorecipes.model.Recipe
import com.example.demorecipes.repository.RecipeRepository
import org.springframework.web.bind.annotation.*

/**
 * Controller class for managing recipes.
 */
@RestController
@RequestMapping("/recipes")
class RecipeController {
    RecipeRepository recipeRepository

    /**
     * Constructs a new RecipeController with the given RecipeRepository.
     *
     * @param recipeRepository The repository used for accessing Recipe data.
     */
    RecipeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository
    }

    /**
     * Retrieves all recipes.
     *
     * @return A list of all recipes.
     */
    @GetMapping("/")
    List<Recipe> getAllRecipes() {
        recipeRepository.findAll()
    }

    /**
     * Retrieves a recipe by its ID.
     *
     * @param id The ID of the recipe to retrieve.
     * @return The recipe with the specified ID, or null if not found.
     */
    @GetMapping("/{id}")
    Recipe getRecipeById(@PathVariable Long id) {
        recipeRepository.findById(id).orElse(null)
    }

    /**
     * Creates a new recipe.
     *
     * @param recipe The recipe to create.
     * @return The created recipe.
     */
    @PostMapping("/")
    Recipe createRecipe(@RequestBody Recipe recipe) {
        recipeRepository.save(recipe)
    }

    /**
     * Updates an existing recipe.
     *
     * @param id            The ID of the recipe to update.
     * @param updatedRecipe The updated recipe data.
     * @return The updated recipe, or null if the recipe with the specified ID was not found.
     */
    @PutMapping("/{id}")
    Recipe updateRecipe(@PathVariable Long id, @RequestBody Recipe updatedRecipe) {
        recipeRepository.findById(id).map { recipe ->
            recipe.name = updatedRecipe.name
            recipe.description = updatedRecipe.description
            // Update more properties as needed
            recipeRepository.save(recipe)
        }.orElse(null)
    }

    /**
     * Deletes a recipe by its ID.
     *
     * @param id The ID of the recipe to delete.
     */
    @DeleteMapping("/{id}")
    void deleteRecipe(@PathVariable Long id) {
        recipeRepository.deleteById(id)
    }
}
