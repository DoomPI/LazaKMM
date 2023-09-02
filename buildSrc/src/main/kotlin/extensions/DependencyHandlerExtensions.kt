import org.gradle.api.artifacts.ModuleDependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler

fun KotlinDependencyHandler.useModule(moduleNotation: String) {
    implementation(project(moduleNotation))
}

fun KotlinDependencyHandler.shareModule(moduleNotation: String) {
    api(project(moduleNotation))
}

fun KotlinDependencyHandler.useBaseUIAndroidLibraries() {
    implementation(Dependencies.Android.AndroidX.AppCompat.appCompat)
    implementation(Dependencies.Glide.glide)
}

fun DependencyHandler.useCommonAndroidPresentationLibraries() {
    add(IMPLEMENTATION, Dependencies.Android.AndroidX.AppCompat.appCompat)
    add(IMPLEMENTATION, Dependencies.Glide.glide)
}

fun DependencyHandler.useCommonAndroidDataLibraries() {
    add(IMPLEMENTATION, Dependencies.Android.AndroidX.Core.coreKtx)
}

fun KotlinDependencyHandler.useCommonDomainLibraries() {

}

fun KotlinDependencyHandler.useCommonDataLibraries() {
    implementation(Dependencies.DivKit.data)
    implementation(Dependencies.DivKit.core)
    implementation(Dependencies.DivKit.json)
}

fun DependencyHandler.useModule(moduleNotation: String) {
    add(IMPLEMENTATION, project(mapOf("path" to moduleNotation)))
}

@Suppress("UNCHECKED_CAST")
fun <T : ModuleDependency> T.exclude(group: String? = null, module: String? = null): T =
    exclude(excludeMapFor(group, module)) as T

private fun excludeMapFor(group: String?, module: String?): Map<String, String> =
    mapOfNonNullValuesof(
        "group" to group,
        "module" to module,
    )

private fun mapOfNonNullValuesof(vararg entries: Pair<String, String?>): Map<String, String> =
    entries.mapNotNull { entry ->
        entry.second?.let { value ->
            entry.first to value
        }
    }.toMap()

private const val COMPILE_ONLY = "compileOnly"
private const val IMPLEMENTATION = "implementation"
private const val TEST_IMPLEMENTATION = "testImplementation"
private const val RUNTIME_ONLY = "runtimeOnly"
private const val API = "api"