package com.example.recyclerviewrecipe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class FullRecipeActivity extends AppCompatActivity {

    TextView recipeInstruction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_recipe);

        recipeInstruction = findViewById(R.id.fullRecipe);

        Bundle bundle = getIntent().getExtras();

        recipeInstruction.setText(bundle.getString("FULLRECIPE"));
    }
}