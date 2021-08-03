package ru.artkolest.chucknorrisapp.di.components

import dagger.Subcomponent
import ru.artkolest.chucknorrisapp.di.modules.JokeInfoModule
import ru.artkolest.chucknorrisapp.di.scopes.JokeInfoScope
import ru.artkolest.chucknorrisapp.presentation.joke_info.JokeInfoFragment

@JokeInfoScope
@Subcomponent(modules = [JokeInfoModule::class])
interface JokeInfoComponent {
    fun inject(fragment: JokeInfoFragment)
}