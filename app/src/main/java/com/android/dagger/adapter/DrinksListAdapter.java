package com.android.dagger.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.dagger.R;
import com.android.dagger.databinding.ItemDrinksBinding;
import com.android.dagger.model.entity.DrinkListModel;
import com.android.dagger.ui.activity.DetailDrinksActivity;
import com.android.dagger.util.Constants;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class DrinksListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<DrinkListModel.Drinks> drinks;
    private Context context;

    public DrinksListAdapter(Context context, List<DrinkListModel.Drinks> drinks) {
        this.context = context;
        this.drinks = drinks;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_drinks, viewGroup, false);
        return new DrinksHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        DrinksHolder recipeHolder = (DrinksHolder) viewHolder;

        recipeHolder.itemDrinksBinding.setDrinks(drinks.get(i));

    }

    @Override
    public int getItemCount() {
        return drinks.size();
    }

    private class DrinksHolder extends RecyclerView.ViewHolder {

        ItemDrinksBinding itemDrinksBinding;

        DrinksHolder(@NonNull View itemView) {
            super(itemView);
            itemDrinksBinding = DataBindingUtil.bind(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context, DetailDrinksActivity.class)
                            .putExtra(Constants.DRINK_ID, drinks.get(getAdapterPosition()).getIdDrink()));
                }
            });
        }
    }

}
