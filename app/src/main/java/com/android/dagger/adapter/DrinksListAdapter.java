package com.android.dagger.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.dagger.R;
import com.android.dagger.databinding.ItemDrinksBinding;
import com.android.dagger.model.entity.DrinkListModel;
import com.android.dagger.ui.dialog.DrinkDetailDialog;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

public class DrinksListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<DrinkListModel.Drinks> drinks;
    private FragmentManager manager;

    @Inject
    public DrinksListAdapter(FragmentManager manager) {
        this.manager = manager;
    }

    public void addItems(List<DrinkListModel.Drinks> drinks){
        this.drinks = drinks;
        notifyDataSetChanged();
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
                    DrinkDetailDialog.newInstance(drinks.get(getAdapterPosition()).getIdDrink()).showDialog(manager,DrinkDetailDialog.class.getName());
                }
            });
        }
    }

}
