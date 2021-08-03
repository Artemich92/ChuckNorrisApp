package ru.artkolest.chucknorrisapp.di.modules

import dagger.Binds
import dagger.Module
import ru.artkolest.chucknorrisapp.di.scopes.JokeInfoScope
import ru.artkolest.chucknorrisapp.presentation.joke_info.JokeInfoContract
import ru.artkolest.chucknorrisapp.presentation.joke_info.JokeInfoPresenter

@Module
interface JokeInfoModule {

    @JokeInfoScope
    @Binds
    fun presenter(presenter: JokeInfoPresenter): JokeInfoContract.Presenter
}