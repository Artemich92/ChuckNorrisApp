package ru.artkolest.chucknorrisapp.di.components

import dagger.Subcomponent
import ru.artkolest.chucknorrisapp.di.modules.JokesListModule
import ru.artkolest.chucknorrisapp.di.scopes.JokesListScope
import ru.artkolest.chucknorrisapp.presentation.jokes_list.JokesListFragment

@JokesListScope
@Subcomponent(modules = [JokesListModule::class])
interface JokesListComponent {
    fun inject(fragment: JokesListFragment)
}