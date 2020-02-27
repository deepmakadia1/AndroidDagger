package com.android.dagger.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.dagger.R;
import com.android.dagger.databinding.ItemRecipeBinding;
import com.android.dagger.model.entity.RecipeModel;
import com.android.dagger.ui.dialog.RecipeDetailDialog;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecipeListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<RecipeModel.Recipe> meals = new ArrayList<>();
    private FragmentManager manager;

    @Inject
    public RecipeListAdapter(FragmentManager manager) {
        this.manager = manager;
    }

    public void addItems( List<RecipeModel.Recipe> meals){
        this.meals = meals;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recipe, viewGroup, false);
        return new RecipeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        RecipeHolder recipeHolder = (RecipeHolder) viewHolder;

        recipeHolder.itemRecipeBinding.setRecipe(meals.get(i));

    }

    @Override
    public int getItemCount() {
        return meals.size();
    }

    private class RecipeHolder extends RecyclerView.ViewHolder {

        ItemRecipeBinding itemRecipeBinding;

        RecipeHolder(@NonNull View itemView) {
            super(itemView);
            itemRecipeBinding = DataBindingUtil.bind(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    RecipeDetailDialog.newInstance(meals.get(getAdapterPosition()).getIdMeal()).showDialog(manager,RecipeDetailDialog.class.getName());
                }
            });
        }
    }

}
