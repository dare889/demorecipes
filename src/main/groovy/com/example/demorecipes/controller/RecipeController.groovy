package com.example.demorecipes.controller

import com.example.demorecipes.model.Recipe
import com.example.demorecipes.repository.RecipeRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/recipes")
class RecipeController {
    RecipeRepository recipeRepository

    RecipeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository
    }

    @GetMapping("/")
    List<Recipe> getAllRecipes() {
        recipeRepository.findAll()
    }

    @GetMapping("/{id}")
    Recipe getRecipeById(@PathVariable Long id) {
        recipeRepository.findById(id).orElse(null)
    }

    @PostMapping("/")
    Recipe createRecipe(@RequestBody Recipe recipe) {
        recipeRepository.save(recipe)
    }

    @PutMapping("/{id}")
    Recipe updateRecipe(@PathVariable Long id, @RequestBody Recipe updatedRecipe) {
        recipeRepository.findById(id).map { recipe ->
            recipe.name = updatedRecipe.name
            recipe.description = updatedRecipe.description
            // Update more properties as needed
            recipeRepository.save(recipe)
        }.orElse(null)
    }

    @DeleteMapping("/{id}")
    void deleteRecipe(@PathVariable Long id) {
        recipeRepository.deleteById(id)
    }
}