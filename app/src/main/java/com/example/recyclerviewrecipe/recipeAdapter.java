package com.example.recyclerviewrecipe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recipeAdapter  extends RecyclerView.Adapter<recipeAdapter.MyViewHolder> {

    private final ArrayList<Recipe> recipeArrayList;
    final private LayoutInflater inflater;

    public recipeAdapter(Context context, ArrayList<Recipe> recipeArrayList) {
        inflater = LayoutInflater.from(context);
        this.recipeArrayList = recipeArrayList;
    }

    @NonNull
    @Override
    public recipeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.recycler_view_row,
                parent, false);
        return new MyViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull recipeAdapter.MyViewHolder holder, int position) {
        Recipe currentRecipe = recipeArrayList.get(position);
        holder.recipeTitle.setText(currentRecipe.getRecipeName());
        //set the second text view to the user's phone number
        holder.description.setText(currentRecipe.getRecipeDescription());
//        holder.instructions.setText(currentRecipe.getFullRecipe());
    }

    @Override
    public int getItemCount() {
        return recipeArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final TextView recipeTitle, description, instructions;
        recipeAdapter rAdapter;
//        final recipeAdapter rAdapter;
        Context context;

        public MyViewHolder(View itemView, recipeAdapter recipeAdapter) {
            super(itemView);
            context = itemView.getContext();

            recipeTitle = itemView.findViewById(R.id.recipeName);
            description = itemView.findViewById(R.id.recipeDescription);
            instructions = itemView.findViewById(R.id.fullRecipe);
            this.rAdapter = recipeAdapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Recipe fullRecipe = recipeArrayList.get(getAdapterPosition());
            startNextActivity(fullRecipe);
        }

        private void startNextActivity(Recipe fullRecipe) {
            Intent intent = new Intent(context, FullRecipeActivity.class);
            Bundle bundles = new Bundle();

            bundles.putString("FULLRECIPE", fullRecipe.getFullRecipe());
//            Recipe recipes = recipeArrayList.get(getAdapterPosition());
            intent.putExtras(bundles);
            context.startActivity(intent);
        }
    }
}
