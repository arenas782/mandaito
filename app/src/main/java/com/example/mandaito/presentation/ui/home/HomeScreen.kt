package com.example.mandaito.presentation.ui.home

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mandaito.R
import com.example.mandaito.domain.model.Category
import com.example.mandaito.presentation.theme.MandaitoTheme
import com.example.mandaito.presentation.theme.Typography
import com.example.mandaito.presentation.uielement.CategoryBox
import com.example.mandaito.presentation.uielement.MainBackground
import com.example.mandaito.presentation.util.NavEvent


@Composable
@Preview
fun HomeScreen(
    onNavigate: (NavEvent.Navigate) -> Unit = {},
    onPopAndNavigate: (NavEvent.PopAndNavigate) -> Unit = {},
    viewModel: HomeViewModel = hiltViewModel()

) {

    MainBackground(
        backgroundColor = MandaitoTheme.colors.background,
        content = {
            CategoriesList(viewModel.uiState.categories)
        }
    )
}

@Composable
fun CategoriesList(items: ArrayList<Category>) {
    if(items.isEmpty().not()){
        LazyRow {
            items.forEach{category ->
                item {
                    CategoryBox(
                        iconResource = R.drawable.alcohol,
                        title = category.name,
                    )
                }
            }
        }
    }
}