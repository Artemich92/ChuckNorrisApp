package ru.artkolest.chucknorrisapp.presentation.joke_info

import ru.artkolest.chucknorrisapp.base.BaseContract

interface JokeInfoContract {

    interface View: BaseContract.View{
        fun onShowLoad()
        fun onHideLoad()
    }

    interface Presenter: BaseContract.Presenter{
        var view: View
    }
}