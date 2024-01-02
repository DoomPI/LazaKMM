plugins {
    `multiplatform-setup`
    `android-setup`
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(Dependencies.Kotlin.Coroutines.core)

                api(Dependencies.Kodein.core)
            }
        }

        androidMain {
            dependencies {

            }
        }

        iosMain {
            dependencies {
                
            }
        }
    }
}