package ru.pyroman.laza.common.core.utils.ref

expect class WeakReference<T : Any>(referred: T) {

    fun clear()

    fun get(): T?
}