package ru.artkolest.chucknorrisapp.presentation.jokes_list

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.artkolest.chucknorrisapp.base.BasePresenter
import ru.artkolest.chucknorrisapp.di.scopes.JokesListScope
import ru.artkolest.chucknorrisapp.domain.NetworkDataSource
import ru.artkolest.chucknorrisapp.domain.model.Value
import javax.inject.Inject

@JokesListScope
class JokesListPresenter @Inject constructor(
    private val networkDataSource: NetworkDataSource,
) : BasePresenter<JokesListContract.View>(), JokesListContract.Presenter {

    override lateinit var view: JokesListContract.View
    private var jokes = ArrayList<Value>()

    override fun start() = Unit

    override fun loadJokes(countJokes: String?) {
        if (countJokes.isNullOrEmpty().not()) {
            disposables += networkDataSource.getJokes(countJokes.toString())
                .toObservable()
                .flatMapIterable { it.value }
                .map {
                    jokes.add(Value(it.joke))
                }
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doAfterTerminate { view.onHideLoad() }
                .subscribe({
                    view.onSetData(jokes)
                }, { view.showError(it) })
        } else {
            view.onHideLoad()
            view.onShowErrorToast()
        }
    }
}