package ru.artkolest.chucknorrisapp.domain

import io.reactivex.Single

interface NetworkDataSource {

    fun getJokes(): Single<JokeEntity>
}