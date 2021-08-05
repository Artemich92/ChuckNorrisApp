package ru.artkolest.chucknorrisapp.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.artkolest.chucknorrisapp.App
import ru.artkolest.chucknorrisapp.R
import ru.artkolest.chucknorrisapp.base.BaseActivity
import ru.artkolest.chucknorrisapp.databinding.ActivityMainBinding

class MainActivity : BaseActivity<MainContract.Presenter>(),
MainContract.View{

    private lateinit var navController: NavController
    private  val binding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        presenter.view = this
        binding.bottomNavView.setupWithNavController(navController)
    }

    override fun createComponent() {
        App.instanse.getAppComponent().createMainActivity().inject(this)
    }
}