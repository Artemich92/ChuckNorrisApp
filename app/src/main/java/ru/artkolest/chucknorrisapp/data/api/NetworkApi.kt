package ru.artkolest.chucknorrisapp.data.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import ru.artkolest.chucknorrisapp.domain.model.ResponseJokeEntity

interface NetworkApi {

    @GET("jokes/random/{countJokes}")
    fun getRandomJokes(
        @Path("countJokes") countJokes: String
    ): Single<ResponseJokeEntity>
}