package ru.artkolest.chucknorrisapp.presentation.jokes_list

import ru.artkolest.chucknorrisapp.base.BaseContract
import ru.artkolest.chucknorrisapp.presentation.joke_info.JokeInfoContract

interface JokesListContract {

    interface view : BaseContract.View {

    }

    interface Presenter : BaseContract.Presenter {
        var view: JokeInfoContract.View
    }
}