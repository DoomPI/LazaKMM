package ru.pyroman.lazakmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform