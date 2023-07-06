package com.example.demorecipes.repository

import com.example.demorecipes.model.Recipe
import org.springframework.data.jpa.repository.JpaRepository

interface RecipeRepository extends JpaRepository<Recipe, Long> {
}