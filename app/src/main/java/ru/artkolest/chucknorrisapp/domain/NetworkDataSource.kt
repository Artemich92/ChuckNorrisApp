package ru.artkolest.chucknorrisapp.domain

import io.reactivex.Single
import ru.artkolest.chucknorrisapp.domain.model.ResponseJokeEntity

interface NetworkDataSource {

    fun getJokes(countJokes: String): Single<ResponseJokeEntity>
}