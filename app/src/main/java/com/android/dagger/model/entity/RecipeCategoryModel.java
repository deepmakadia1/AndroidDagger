package com.android.dagger.model.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RecipeCategoryModel {


    @SerializedName("categories")
    private List<Categories> categories;

    public List<Categories> getCategories() {
        return categories;
    }


    public static class Categories {
        /**
         * idCategory : 1
         * strCategory : Beef
         * strCategoryThumb : https://www.themealdb.com/images/category/beef.png
         * strCategoryDescription : Beef is the culinary name for meat from cattle, particularly skeletal muscle. Humans have been eating beef since prehistoric times.[1] Beef is a source of high-quality protein and essential nutrients.[2]
         */

        @SerializedName("strCategory")
        private String strCategory;

        public String getStrCategory() {
            return strCategory;
        }


    }
}
