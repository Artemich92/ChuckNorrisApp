package ru.artkolest.chucknorrisapp.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject

abstract class BaseActivity<P : BaseContract.Presenter>
    : AppCompatActivity(), BaseContract.View {

    @Inject
    lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createComponent()
    }

    protected abstract fun createComponent()

    override fun onDestroy() {
        super.onDestroy()
        presenter.stop()
    }
}