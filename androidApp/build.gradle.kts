plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "ru.pyroman.laza.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "ru.pyroman.laza.android"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    useCommonAndroidPresentationLibraries()
    useCommonAndroidDataLibraries()

    useModule(ProjectModules.Common.core)
    useModule(ProjectModules.Common.umbrellaAndroid)

    useModule(ProjectModules.Domain.product)

    implementation(Dependencies.DivKit.div)
    implementation(Dependencies.DivKit.data)
    implementation(Dependencies.DivKit.core)
    implementation(Dependencies.DivKit.json)
}