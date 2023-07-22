package com.example.mandaito.data.di

import android.content.Context
import com.example.mandaito.data.util.Connectivity
import com.example.mandaito.data.util.ConnectivityImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun provideConnectivity(@ApplicationContext context: Context): Connectivity =
        ConnectivityImpl(context)
}