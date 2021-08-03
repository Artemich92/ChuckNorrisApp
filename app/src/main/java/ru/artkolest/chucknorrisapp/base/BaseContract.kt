package ru.artkolest.chucknorrisapp.base

interface BaseContract {

    interface View

    interface Presenter{
        fun start()
        fun stop()
        fun dispose()
    }
}