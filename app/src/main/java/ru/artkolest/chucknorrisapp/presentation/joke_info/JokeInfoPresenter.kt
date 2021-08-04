package ru.artkolest.chucknorrisapp.presentation.joke_info

import ru.artkolest.chucknorrisapp.base.BasePresenter
import ru.artkolest.chucknorrisapp.di.scopes.JokeInfoScope
import javax.inject.Inject

@JokeInfoScope
class JokeInfoPresenter @Inject constructor(

): BasePresenter<JokeInfoContract.View>(),
JokeInfoContract.Presenter{

    override lateinit var view: JokeInfoContract.View

    override fun start() {

    }

    override fun stop() {

    }

    override fun dispose() {

    }
}