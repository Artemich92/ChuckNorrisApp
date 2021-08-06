package ru.artkolest.chucknorrisapp.presentation.jokes_list

import ru.artkolest.chucknorrisapp.base.BaseContract
import ru.artkolest.chucknorrisapp.domain.model.Value

interface JokesListContract {

    interface View : BaseContract.View {
        fun onSetData(postInfo: List<Value>)
        fun showError(throwable: Throwable)
        fun onShowErrorToast()
        fun onShowLoad()
        fun onHideLoad()

    }

    interface Presenter : BaseContract.Presenter {
        var view: View
        fun loadJokes(countJokes: String?)
    }
}