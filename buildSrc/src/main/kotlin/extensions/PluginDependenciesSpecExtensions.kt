import org.gradle.kotlin.dsl.kotlin
import org.gradle.kotlin.dsl.version
import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

val PluginDependenciesSpec.kotlinSerialization: PluginDependencySpec
    get() = kotlin(Plugins.Kotlin.serialization) version Plugins.Kotlin.version

val PluginDependenciesSpec.kmpSwiftPackage: PluginDependencySpec
    get() = id(Plugins.Pyroman.KmpSwiftPackage.kmpSwiftPackage) version
            Plugins.Pyroman.KmpSwiftPackage.version

val PluginDependenciesSpec.commonModuleSetup: PluginDependencySpec
    get() = id(Plugins.Local.CommonModuleSetup.commonModuleSetup)