package ru.artkolest.chucknorrisapp.presentation.main

import ru.artkolest.chucknorrisapp.base.BaseContract

interface MainContract {

    interface View : BaseContract.View {

    }

    interface Presenter : BaseContract.Presenter {
        var view: View
    }
}