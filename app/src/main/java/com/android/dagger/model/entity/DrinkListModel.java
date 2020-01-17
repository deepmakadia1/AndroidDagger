package com.android.dagger.model.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DrinkListModel {


    @SerializedName("drinks")
    private List<Drinks> drinks;

    public List<Drinks> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drinks> drinks) {
        this.drinks = drinks;
    }

    public static class Drinks {
        /**
         * strDrink : '57 Chevy with a White License Plate
         * strDrinkThumb : https://www.thecocktaildb.com/images/media/drink/qyyvtu1468878544.jpg
         * idDrink : 14029
         */

        @SerializedName("strDrink")
        private String strDrink;
        @SerializedName("strDrinkThumb")
        private String strDrinkThumb;
        @SerializedName("idDrink")
        private String idDrink;

        public String getStrDrink() {
            return strDrink;
        }

        public String getStrDrinkThumb() {
            return strDrinkThumb;
        }

        public String getIdDrink() {
            return idDrink;
        }

    }
}
