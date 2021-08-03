package ru.artkolest.chucknorrisapp.di.modules

import dagger.Binds
import dagger.Module
import ru.artkolest.chucknorrisapp.di.scopes.MainScope
import ru.artkolest.chucknorrisapp.presentation.main.MainContract
import ru.artkolest.chucknorrisapp.presentation.main.MainPresenter

@Module
interface MainModule {

    @MainScope
    @Binds
    fun presenter(presenter: MainPresenter): MainContract.Presenter
}