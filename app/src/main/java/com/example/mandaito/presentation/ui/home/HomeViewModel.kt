package com.example.mandaito.presentation.ui.home


import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.mandaito.domain.interaction.GetCategoriesUseCase
import com.example.mandaito.domain.model.Category
import com.example.mandaito.domain.model.onFailure
import com.example.mandaito.domain.model.onLoading
import com.example.mandaito.domain.model.onSuccess
import com.example.mandaito.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(getCategoriesUseCase: GetCategoriesUseCase) :
    BaseViewModel() {
    var uiState by mutableStateOf(UIState())
        private set

    init {
        executeUseCase {
            getCategoriesUseCase.invoke().onSuccess {
                uiState = uiState.copy(categories = it)
                println("----------- SUCCESS")
            }.onFailure {
                println("----------- FAILURE ${it.errorCode}")
            }.onLoading {
                println("----------- LOADING")
            }

        }
    }


    data class UIState(
        // Fields
        val categories: ArrayList<Category> = arrayListOf(),
        val isLoading: Boolean? = false
    )

}