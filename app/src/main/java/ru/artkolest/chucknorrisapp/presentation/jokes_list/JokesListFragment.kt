package ru.artkolest.chucknorrisapp.presentation.jokes_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.artkolest.chucknorrisapp.App
import ru.artkolest.chucknorrisapp.R
import ru.artkolest.chucknorrisapp.base.BaseFragment
import ru.artkolest.chucknorrisapp.databinding.FragmentJokesListBinding

class JokesListFragment : BaseFragment<JokesListContract.Presenter>(R.layout.fragment_jokes_list),
JokesListContract.View{

    private lateinit var navController: NavController
    private val binding by viewBinding(FragmentJokesListBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.view = this
        navController = view.findNavController()
        initUI()
        binding.toolbar
    }

    private fun initUI() = with(binding){
        toolbar.tvTitle.setText(R.string.jokes)
    }

    override fun createComponent() = App.instanse.getAppComponent()
        .createJokesListFragment().inject(this)


}