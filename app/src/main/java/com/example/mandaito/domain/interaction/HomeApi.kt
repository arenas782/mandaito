package com.example.mandaito.domain.interaction

import com.example.mandaito.domain.model.Category
import com.google.gson.JsonArray
import retrofit2.Response
import retrofit2.http.GET

interface HomeApi {
    @GET("categories/")
    suspend fun getCategories(): Response<ArrayList<Category>>
}