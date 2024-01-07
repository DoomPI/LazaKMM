import org.gradle.kotlin.dsl.kotlin
import org.gradle.kotlin.dsl.version
import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

val PluginDependenciesSpec.kotlinSerialization: PluginDependencySpec
    get() = kotlin(Plugins.Kotlin.serialization) version Plugins.Kotlin.version

val PluginDependenciesSpec.kotlinNativeCocoapods: PluginDependencySpec
    get() = kotlin(Plugins.Kotlin.nativeCocoapods)