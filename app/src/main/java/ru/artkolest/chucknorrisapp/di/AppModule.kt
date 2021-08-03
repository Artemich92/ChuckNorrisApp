package ru.artkolest.chucknorrisapp.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule (
    private val appContext: Context,
            private val application: Application
){

    @Singleton
    @Provides
    fun ProvideApplication(): Application = application

    @Singleton
    @Provides
    fun provideContext(): Context = appContext
}