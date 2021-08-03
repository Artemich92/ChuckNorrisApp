package ru.artkolest.chucknorrisapp.di.modules

import dagger.Binds
import dagger.Module
import ru.artkolest.chucknorrisapp.di.scopes.JokesListScope
import ru.artkolest.chucknorrisapp.presentation.jokes_list.JokesListContract
import ru.artkolest.chucknorrisapp.presentation.jokes_list.JokesListPresenter

@Module
interface JokesListModule {

    @JokesListScope
    @Binds
    fun presenter(presenter: JokesListPresenter):JokesListContract.Presenter
}