package com.android.dagger.model.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import androidx.annotation.Keep;

@Keep
public class DrinkDetailModel {

    @SerializedName("drinks")
    private List<Drink> drinks;

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }

    public static class Drink {
        /**
         * idDrink : 11007
         * strDrink : Margarita
         * strTags : IBA,ContemporaryClassic
         * strVideo : null
         * strCategory : Ordinary Drink
         * strAlcoholic : Alcoholic
         * strGlass : Cocktail glass
         * strInstructions : Rub the rim of the glass with the lime slice to make the salt stick to it. Take care to moisten only the outer rim and sprinkle the salt on it. The salt should present to the lips of the imbiber and never mix into the cocktail. Shake the other ingredients with ice, then carefully pour into the glass.
         */

        @SerializedName("idDrink")
        private String idDrink;
        @SerializedName("strDrink")
        private String strDrink;
        @SerializedName("strTags")
        private String strTags;
        @SerializedName("strVideo")
        private Object strVideo;
        @SerializedName("strCategory")
        private String strCategory;
        @SerializedName("strAlcoholic")
        private String strAlcoholic;
        @SerializedName("strGlass")
        private String strGlass;
        @SerializedName("strInstructions")
        private String strInstructions;
        @SerializedName("strDrinkThumb")
        private String strDrinkThumb;

        public String getStrDrink() {
            return strDrink;
        }

        public String getStrTags() {
            return strTags;
        }

        public String getStrCategory() {
            return strCategory;
        }

        public String getStrAlcoholic() {
            return strAlcoholic;
        }

        public String getStrGlass() {
            return strGlass;
        }

        public String getStrInstructions() {
            return strInstructions;
        }

        public String getStrDrinkThumb() {
            return strDrinkThumb;
        }
    }
}
