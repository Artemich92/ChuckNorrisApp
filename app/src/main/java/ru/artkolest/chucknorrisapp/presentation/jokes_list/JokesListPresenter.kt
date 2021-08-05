package ru.artkolest.chucknorrisapp.presentation.jokes_list

import ru.artkolest.chucknorrisapp.base.BasePresenter
import ru.artkolest.chucknorrisapp.di.scopes.JokesListScope
import ru.artkolest.chucknorrisapp.domain.NetworkDataSource
import javax.inject.Inject

@JokesListScope
class JokesListPresenter @Inject constructor(
//private val networkDataSource: NetworkDataSource
): BasePresenter<JokesListContract.View>(), JokesListContract.Presenter{

    override lateinit var view: JokesListContract.View

    override fun start() {

    }

    override fun stop() {

    }

    override fun dispose() {

    }

}