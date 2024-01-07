import org.json.JSONArray

val projectModules = JSONArray(File(rootDir, "project-modules.json").readText())
for (index in 0 until projectModules.length()) {
    val jsonObject = projectModules.getJSONObject(index)
    val module = jsonObject.getString("module")
    val path = jsonObject.getString("path")
    include(module)
    project(module).projectDir = File(rootDir, path)
}

pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        mavenLocal()
        google()
    }
}

rootProject.name = "LazaKMM"

include(":common:umbrella-android")
include(":common:umbrella-ios")

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.json:json:20230227")
    }
}