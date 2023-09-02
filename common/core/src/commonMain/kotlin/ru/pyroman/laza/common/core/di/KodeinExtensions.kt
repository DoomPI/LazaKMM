package ru.pyroman.laza.common.core.di

import org.kodein.di.DI
import org.kodein.di.DirectDIAware
import org.kodein.di.bind
import org.kodein.di.bindings.BindingDI
import org.kodein.di.bindings.NoArgBindingDI
import org.kodein.di.bindings.RefMaker
import org.kodein.di.instance
import org.kodein.di.provider
import org.kodein.di.singleton
import org.kodein.di.factory

inline fun <reified T> DirectDIAware.lazyInstance(): Lazy<T> = lazy { instance() }

inline fun module(
    name: String,
    allowSilentOverride: Boolean = false,
    prefix: String = "",
    noinline init: DI.Builder.() -> Unit,
) = DI.Module(name, allowSilentOverride, prefix, init)

inline fun <reified T : Any> DI.Builder.provider(
    tag: Any? = null,
    overrides: Boolean? = null,
    noinline creator: NoArgBindingDI<Any>.() -> T,
) = bind<T>(tag, overrides) with provider(creator)

inline fun <reified T : Any> DI.Builder.singleton(
    tag: Any? = null,
    overrides: Boolean? = null,
    ref: RefMaker? = null,
    sync: Boolean = true,
    noinline creator: NoArgBindingDI<Any>.() -> T,
) = bind<T>(tag, overrides) with singleton(ref, sync, creator)

inline fun <reified A : Any, reified T : Any> DI.Builder.factory(
    tag: Any? = null,
    overrides: Boolean? = null,
    noinline creator: BindingDI<Any>.(A) -> T,
) = bind<T>(tag, overrides) with factory(creator)

