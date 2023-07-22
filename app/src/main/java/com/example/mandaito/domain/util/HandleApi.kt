package com.example.mandaito.domain.util

import com.example.mandaito.domain.model.ApiResult
import retrofit2.HttpException
import retrofit2.Response


suspend fun <T : Any> handleApi(
    execute: suspend () -> Response<T>
): ApiResult<T> {
    return try {

        val response = execute()
        val body = response.body()
        if (response.isSuccessful && body != null) {
            ApiResult.Success(body)
        } else {
            ApiResult.Failure(
                HttpError(
                    Throwable(
                        response.message()
                    ), errorCode = response.code()
                )
            )
        }
    } catch (e: HttpException) {
        ApiResult.Failure(
            HttpError(
                Throwable(
                    e.message()
                ), errorCode = e.code()
            )
        )
    } catch (e: Throwable) {
        ApiResult.Failure(
            HttpError(
                Throwable(
                    e.message
                )
            )
        )
    }
}