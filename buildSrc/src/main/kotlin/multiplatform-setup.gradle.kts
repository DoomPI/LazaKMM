plugins {
    `android-library`
    `kotlin-multiplatform`
    `kotlin-kapt`
}

kotlin {
    android()
    ios()
    iosX64()
    iosArm64()
    iosSimulatorArm64()
}