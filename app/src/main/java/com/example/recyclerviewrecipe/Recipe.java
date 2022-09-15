package com.example.recyclerviewrecipe;

public class Recipe {

    String recipeName;
    String recipeDescription;
    String fullRecipe;
    int index;


    //assign current object to the set parameters
    public Recipe(String recipeName, String recipeDescription, String fullRecipe) {
        this.recipeName = recipeName;
        this.recipeDescription = recipeDescription;
        this.fullRecipe = fullRecipe;
    }

    //getters
    public String getRecipeName() {
        return recipeName;
    }

    public String getRecipeDescription() {
        return recipeDescription;
    }

    public String getFullRecipe() { return  fullRecipe; }

    public int getIndex() {
        return index;
    }
}
