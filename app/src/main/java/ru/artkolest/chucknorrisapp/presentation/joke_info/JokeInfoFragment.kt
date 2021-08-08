package ru.artkolest.chucknorrisapp.presentation.joke_info

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.navigation.NavController
import androidx.navigation.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import kotlinx.android.synthetic.main.fragment_joke_info.*
import kotlinx.android.synthetic.main.fragment_jokes_list.gLoad
import ru.artkolest.chucknorrisapp.App
import ru.artkolest.chucknorrisapp.R
import ru.artkolest.chucknorrisapp.base.BaseFragment
import ru.artkolest.chucknorrisapp.base.extensions.hide
import ru.artkolest.chucknorrisapp.base.extensions.show
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
        if (savedInstanceState != null){
            webView.restoreState(savedInstanceState)
        } else{
            loadUrl()
        }
    }

    private fun initUI() = with(binding){
        toolbar.tvTitle.setText(R.string.app_info)
    }

    private fun loadUrl(){
        webView.webViewClient = object : WebViewClient() {

            override fun onPageStarted(view: WebView, url: String, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                view.visibility = View.INVISIBLE
                onShowLoad()
            }

            override fun onPageFinished(view: WebView, url: String) {
                super.onPageFinished(view, url)
                view.visibility = View.VISIBLE
                onHideLoad()
            }
        }

        webView.loadUrl(API_URL)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        webView.saveState(outState)
    }

    override fun onShowLoad() = gLoad.show()

    override fun onHideLoad() = gLoad.hide()

    override fun createComponent() = App.instanse.getAppComponent()
        .createJokeInfoFragment().inject(this)

    override fun onDestroyView() {

        super.onDestroyView()
    }

    companion object{
        private const val API_URL = "https://www.icndb.com/api/"
    }
}