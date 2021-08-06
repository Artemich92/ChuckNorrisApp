package ru.artkolest.chucknorrisapp.data

import io.reactivex.Single
import ru.artkolest.chucknorrisapp.data.api.NetworkApi
import ru.artkolest.chucknorrisapp.domain.NetworkDataSource
import ru.artkolest.chucknorrisapp.domain.model.ResponseJokeEntity
import javax.inject.Inject

class NetworkRepository @Inject constructor(
    private val api: NetworkApi
): NetworkDataSource {

    override fun getJokes(countJokes: String): Single<ResponseJokeEntity> {
        return api.getRandomJokes(countJokes)
    }
}