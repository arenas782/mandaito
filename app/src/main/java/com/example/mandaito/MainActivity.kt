package com.example.mandaito

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import com.example.mandaito.presentation.navigation.navgraph.Navigation
import com.example.mandaito.presentation.theme.MandaitoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            MandaitoTheme {
                Navigation()
            }
        }
    }
}