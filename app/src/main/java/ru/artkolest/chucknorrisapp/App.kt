package ru.artkolest.chucknorrisapp

import android.app.Application
import ru.artkolest.chucknorrisapp.di.AppComponent

class App: Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instanse = this
        setUpDagger()
    }

    fun getAppComponent(): AppComponent = appComponent

    private fun setUpDagger(){
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext, this))
            .build()
        appComponent.inject(this)
    }

    companion object{
        lateinit var instanse: App private set
    }
}