package com.example.mandaito.domain.interaction

import com.example.mandaito.domain.model.ApiResult
import com.example.mandaito.domain.model.Category
import com.example.mandaito.domain.util.handleApi
import retrofit2.Response
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(private val api: HomeApi){
    suspend operator fun invoke(): ApiResult<ArrayList<Category>> = handleApi { api.getCategories() }
}