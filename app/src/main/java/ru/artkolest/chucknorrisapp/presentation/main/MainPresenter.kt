package ru.artkolest.chucknorrisapp.presentation.main

import ru.artkolest.chucknorrisapp.base.BasePresenter
import javax.inject.Inject

class MainPresenter @Inject constructor()
    :BasePresenter<MainContract.View>(), MainContract.Presenter{

        override lateinit var view: MainContract.View

    override fun start() {

    }
}