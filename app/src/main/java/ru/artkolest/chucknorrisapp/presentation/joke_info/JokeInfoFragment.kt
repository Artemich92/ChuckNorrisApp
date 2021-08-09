package ru.artkolest.chucknorrisapp.presentation.joke_info

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.satoshun.reactivex.webkit.data.OnPageFinished
import com.github.satoshun.reactivex.webkit.data.OnPageStarted
import io.reactivex.Completable.merge
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_joke_info.*
import kotlinx.android.synthetic.main.fragment_jokes_list.gLoad
import ru.artkolest.chucknorrisapp.App
import ru.artkolest.chucknorrisapp.R
import ru.artkolest.chucknorrisapp.base.BaseFragment
import ru.artkolest.chucknorrisapp.base.extensions.hide
import ru.artkolest.chucknorrisapp.base.extensions.show
import ru.artkolest.chucknorrisapp.databinding.FragmentJokeInfoBinding
import java.util.*

import android.webkit.WebChromeClient

import androidx.appcompat.app.AppCompatActivity
import com.github.satoshun.reactivex.webkit.chromeEvents
import com.github.satoshun.reactivex.webkit.data.OnJsBeforeUnload

import com.github.satoshun.reactivex.webkit.data.OnReceivedIcon
import com.github.satoshun.reactivex.webkit.data.ShouldInterceptRequest
import com.github.satoshun.reactivex.webkit.events
import io.reactivex.Observable


class JokeInfoFragment : BaseFragment<JokeInfoContract.Presenter>(R.layout.fragment_joke_info),
JokeInfoContract.View{

    private val disposables = CompositeDisposable()
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
        disposables.add(
            binding.webView.events(delegate = WebViewClient())
                .publish { shared ->
                    Observable.merge(
                        shared.ofType(OnPageStarted::class.java),
                        shared.ofType(OnPageFinished::class.java)
                    )
                }
                .subscribe { event ->
                    when (event) {
                        is OnPageStarted -> onShowLoad()
                        is OnPageFinished -> onHideLoad()
                    }
                }
        )
        webView.loadUrl(API_URL)
    }


    override fun onSaveInstanceState(outState: Bundle) {
    super.onSaveInstanceState(outState)
    webView.saveState(outState)
    }

    override fun onShowLoad() = gLoad.show()

    override fun onHideLoad() = gLoad.hide()

    override fun onDestroyView() {
    super.onDestroyView()
    disposables.clear()
    }

    companion object{
    private const val API_URL = "https://www.icndb.com/api/"

    }

    override fun createComponent() = App.instanse.getAppComponent()
        .createJokeInfoFragment().inject(this)
}
