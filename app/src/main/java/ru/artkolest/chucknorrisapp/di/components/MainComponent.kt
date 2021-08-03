package ru.artkolest.chucknorrisapp.di.components

import dagger.Subcomponent
import ru.artkolest.chucknorrisapp.di.modules.MainModule
import ru.artkolest.chucknorrisapp.di.scopes.MainScope
import ru.artkolest.chucknorrisapp.presentation.main.MainActivity

@MainScope
@Subcomponent(modules = [MainModule::class])
interface MainComponent {
    fun inject(activity: MainActivity)
}