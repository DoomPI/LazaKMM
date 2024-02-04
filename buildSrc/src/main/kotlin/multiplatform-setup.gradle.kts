plugins {
    `android-library`
    `kotlin-multiplatform`
    `kotlin-kapt`
}

kotlin {
    androidTarget()
    iosX64()
    iosArm64()
    iosSimulatorArm64()
}