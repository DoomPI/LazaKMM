pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "LazaKMM"

include(":androidApp")

include(":common:core")
include(":common:auth:data")
include(":common:auth:domain")
include(":common:auth:presentation")

include(":common:umbrella-android")
include(":common:umbrella-ios")