package com.example.mandaito.presentation.uielement


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mandaito.R
import com.example.mandaito.presentation.theme.MandaitoTheme
import com.example.mandaito.presentation.theme.Typography

@Preview
@Composable
fun CategoryBox(
    modifier: Modifier = Modifier
        .width(120.dp)
        .height(120.dp)
        .padding(8.dp)
        .clip(RoundedCornerShape(15.dp)), iconResource: Int = R.drawable.alcohol,
    title: String = "Title",
    onClick: () -> Unit = {}
) {
    Card(
        modifier = modifier.clickable { onClick.invoke() },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),

    )
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MandaitoTheme.colors.cardBackground),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(id = iconResource),
                contentDescription = "",
                modifier = Modifier
                    .width(45.dp)
                    .height(45.dp),
                contentScale = ContentScale.Crop,
                colorFilter = ColorFilter.tint(MandaitoTheme.colors.iconTintColor)
            )
            Text(
                text = title,
                style = Typography.bodySmall.copy(color = MandaitoTheme.colors.bodyTextColor),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}