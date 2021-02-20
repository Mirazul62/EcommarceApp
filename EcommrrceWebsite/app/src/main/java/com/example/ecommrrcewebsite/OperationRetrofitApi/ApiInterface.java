package com.example.ecommrrcewebsite.OperationRetrofitApi;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("database_connection_php-master/jsonData1.php")
    Call<Users> getCategories();
}
