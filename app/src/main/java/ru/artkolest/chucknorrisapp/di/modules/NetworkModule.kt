package ru.artkolest.chucknorrisapp.di.modules

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.artkolest.chucknorrisapp.data.NetworkRepository
import ru.artkolest.chucknorrisapp.data.api.NetworkApi
import ru.artkolest.chucknorrisapp.domain.NetworkDataSource
import ru.artkolest.chucknorrisapp.util.BASE_URL

@Module
class NetworkModule {

    val gson = GsonBuilder().serializeNulls().create()

    private fun createRetrofitClient(baseUrl: String): Retrofit {
        val okHttpBuilder = OkHttpClient.Builder().addInterceptor(
            HttpLoggingInterceptor().setLevel(
                HttpLoggingInterceptor.Level.BODY)
        )

        return Retrofit.Builder()
            .client(okHttpBuilder.build())
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    fun provideProfileAPI(): NetworkApi{
        return createRetrofitClient(BASE_URL).create(NetworkApi::class.java)
    }

    @Provides
    fun provideProfileDataSource(api: NetworkApi): NetworkDataSource {
        return NetworkRepository(api)
    }
}