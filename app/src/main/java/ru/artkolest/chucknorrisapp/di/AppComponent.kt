package ru.artkolest.chucknorrisapp.di

import dagger.Component
import ru.artkolest.chucknorrisapp.App
import ru.artkolest.chucknorrisapp.di.components.JokeInfoComponent
import ru.artkolest.chucknorrisapp.di.components.JokesListComponent
import ru.artkolest.chucknorrisapp.di.components.MainComponent
import ru.artkolest.chucknorrisapp.di.modules.NetworkModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class
    ]
)
interface AppComponent {
    fun inject(application: App)
    fun createMainActivity(): MainComponent
    fun createJokeInfoFragment(): JokeInfoComponent
    fun createJokesListFragment(): JokesListComponent

}