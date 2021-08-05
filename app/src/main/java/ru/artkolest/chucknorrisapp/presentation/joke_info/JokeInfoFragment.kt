package ru.artkolest.chucknorrisapp.presentation.joke_info

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
import ru.artkolest.chucknorrisapp.databinding.FragmentJokeInfoBinding

class JokeInfoFragment : BaseFragment<JokeInfoContract.Presenter>(R.layout.fragment_joke_info),
JokeInfoContract.View{

    private lateinit var navController: NavController
    private val binding by viewBinding(FragmentJokeInfoBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.view = this
        navController = view.findNavController()
        initUI()
    }

    private fun initUI() = with(binding){
        toolbar.tvTitle.setText(R.string.app_info)
    }

    override fun createComponent() = App.instanse.getAppComponent()
        .createJokeInfoFragment().inject(this)
}