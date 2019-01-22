package com.example.recipesnew;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Food2ForkApiService {

    String API_KEY = "4c2eed9bb8c7f106578f3169021ae029";

    String BASE_URL = "https://www.food2fork.com/api/";

    /**
     * Create a retrofit client.
     */

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @POST ("search/")
    Call<Results> searchRecipes(
            @Query("key") String API_KEY,
            @Query ("term") String searchString,
            @Query ("page") int page);

    @POST ("get/")
    Call<Recipe> getRecipe (
            @Query("key") String API_KEY,
            @Query("rId") String recipeId
    );
}
