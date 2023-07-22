package com.example.mandaito.domain.model

import com.example.mandaito.domain.util.HttpError

sealed class ApiResult<out T> {
    data class Success<out T>(val data: T) : ApiResult<T>()
    data class Message<out T>(val message: T) : ApiResult<T>()
    data class Failure(val httpError: HttpError) : ApiResult<Nothing>()
    data class Loading(val isLoading: Boolean) : ApiResult<Nothing>()
}

inline fun <T : Any?> ApiResult<T>.onSuccess(action: (T) -> Unit): ApiResult<T> {
    if (this is ApiResult.Success) action(data)
    return this
}

inline fun <T : Any?> ApiResult<T>.onMessage(action: (T) -> Unit): ApiResult<T> {
    if (this is ApiResult.Message) action(message)
    return this
}

inline fun <T : Any?> ApiResult<T>.onFailure(action: (HttpError) -> Unit): ApiResult<T> {
    if (this is ApiResult.Failure) action(httpError)
    return this
}

inline fun <T : Any?> ApiResult<T>.onLoading(action: () -> Unit): ApiResult<T> {
    if (this is ApiResult.Loading) action()
    return this
}
