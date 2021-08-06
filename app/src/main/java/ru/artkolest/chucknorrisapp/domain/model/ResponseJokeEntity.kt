package ru.artkolest.chucknorrisapp.domain.model

data class ResponseJokeEntity(
    val type: String,
    val value: List<Value>
)