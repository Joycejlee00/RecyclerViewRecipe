package com.example.recyclerviewrecipe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final private ArrayList<Recipe> recipeArrayList = new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.mRecyclerView);
        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);


        recipeAdapter adapter = new recipeAdapter(this, recipeArrayList);
        // Connection between RecyclerView and adapter.
        recyclerView.setAdapter(adapter);
        // Give the RecyclerView a Linear layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        setRecipe();
    }

    private void setRecipe() {
        String[] getRecipeTitle = getResources().getStringArray(R.array.recipe_name);
        String[] getRecipeDescription = getResources().getStringArray(R.array.recipe_description);
        String[] getFullRecipe = getResources().getStringArray(R.array.full_recipe);

        for (int i = 0; i < getRecipeTitle.length; i++){
            recipeArrayList.add(new Recipe(getRecipeTitle[i], getRecipeDescription[i], getFullRecipe[i]));
        }
    }
}