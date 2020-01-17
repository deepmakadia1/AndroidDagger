package com.android.dagger.model.entity;


import com.google.gson.annotations.SerializedName;

import java.util.List;

import androidx.annotation.Keep;

@Keep
public class DrinkCategoryListModel {

    @SerializedName("drinks")
    private List<DrinkCategories> drinks;

    public List<DrinkCategories> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<DrinkCategories> drinks) {
        this.drinks = drinks;
    }

    public static class DrinkCategories{
        /**
         * strCategory : Ordinary Drink
         */

        @SerializedName("strCategory")
        private String strCategory;
        @SerializedName("strGlass")
        private String strGlass;
        @SerializedName("strIngredient1")
        private String strIngredient1;
        @SerializedName("strAlcoholic")
        private String strAlcoholic;
        private String strData;

        public String getStrData() {
            if (strCategory != null && !strCategory.equals("")) {
                strData = strCategory;
            } else if (strGlass != null && !strGlass.equals("")) {
                strData = strGlass;
            } else if (strIngredient1 != null && !strIngredient1.equals("")) {
                strData = strIngredient1;
            } else if (strAlcoholic != null && !strAlcoholic.equals("")) {
                strData = strAlcoholic;
            }
            return strData;
        }
    }
}
