package ru.artkolest.chucknorrisapp.presentation.jokes_list

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import kotlinx.android.synthetic.main.fragment_jokes_list.*
import ru.artkolest.chucknorrisapp.App
import ru.artkolest.chucknorrisapp.R
import ru.artkolest.chucknorrisapp.base.BaseFragment
import ru.artkolest.chucknorrisapp.base.extensions.hide
import ru.artkolest.chucknorrisapp.base.extensions.onClick
import ru.artkolest.chucknorrisapp.base.extensions.show
import ru.artkolest.chucknorrisapp.databinding.FragmentJokesListBinding
import ru.artkolest.chucknorrisapp.domain.model.Value

class JokesListFragment : BaseFragment<JokesListContract.Presenter>(R.layout.fragment_jokes_list),
JokesListContract.View{

    private val binding by viewBinding(FragmentJokesListBinding::bind)
    private lateinit var navController: NavController
    private lateinit var adapter: JokesListAdapter
    private lateinit var jokesList: ArrayList<Value>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            jokesList = savedInstanceState.getParcelableArrayList<Value>(JOKES_LIST) as ArrayList<Value>
        } else{
            jokesList = ArrayList()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.view = this
        navController = view.findNavController()
        initUI()
        initRecyclerView()
    }

    private fun initUI() = with(binding){
        toolbar.tvTitle.setText(R.string.jokes)
        btnReload.onClick{
            presenter.loadJokes(etCountJokes.text.toString())
        }
    }

    private fun initRecyclerView(){
        val linearLayoutManager = LinearLayoutManager(activity)
        rvJokes.layoutManager = linearLayoutManager
        adapter = JokesListAdapter()
        rvJokes.setHasFixedSize(true)
        rvJokes.adapter = adapter
        if (jokesList.size > 0) adapter.setJoke(jokesList)
    }

    override fun onSetData(jokes: ArrayList<Value>) {
        jokesList = jokes
        adapter.setJoke(jokes)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelableArrayList(JOKES_LIST, jokesList)
    }

    override fun showError(throwable: Throwable) {
        Toast.makeText(requireContext(), throwable.message.toString(), Toast.LENGTH_LONG).show()
    }

    override fun onShowErrorToast() {
        Toast.makeText(requireContext(),
            "Ошибка загрузки шуток, неверное значение countJokes",
            Toast.LENGTH_LONG).show()
    }

    override fun onShowLoad() = gLoad.show()

    override fun onHideLoad() = gLoad.hide()

    override fun createComponent() = App.instanse.getAppComponent()
        .createJokesListFragment().inject(this)

    companion object{
        private const val JOKES_LIST = "jokesList"
    }
}

