package com.example.ecommrrcewebsite.OperationRetrofitApi;


import com.example.ecommrrcewebsite.Models.CategoryModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Users {




    @SerializedName("categories")
    private List<CategoryModel> category;

    public List<CategoryModel> getCategory() {
        return category;
    }
}
