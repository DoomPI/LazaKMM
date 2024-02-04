object Dependencies {

    object Kodein {
        const val core = "org.kodein.di:kodein-di:7.20.2"
    }

    object Kotlin {
        private const val version = "1.9.20"

        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"

        object Serialization  {
            private const val version = "1.5.1"
            const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:$version"
        }

        object Coroutines {
            private const val version = "1.7.3"
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        }
    }

    object DivKit {
        private const val version = "28.2.0"

        const val div = "com.yandex.div:div:$version"
        const val core = "com.yandex.div:div-core:$version"
        const val json = "com.yandex.div:div-json:$version"
        const val data = "com.yandex.div:div-data:$version"
    }

    object Ktor {
        private const val version = "2.3.2"

        const val core = "io.ktor:ktor-client-core:$version"
        const val json = "io.ktor:ktor-client-json:$version"
        const val contentNegotiation = "io.ktor:ktor-client-content-negotiation:$version"
        const val serialization = "io.ktor:ktor-client-serialization:$version"
        const val serializationKotlinX = "io.ktor:ktor-serialization-kotlinx-json:$version"
        const val logging = "io.ktor:ktor-client-logging:$version"
        const val ios = "io.ktor:ktor-client-ios:$version"
        const val android = "io.ktor:ktor-client-android:$version"
    }

    object Glide {
        private const val version = "4.16.0"
        const val glide = "com.github.bumptech.glide:glide:$version"
    }

    object Android {
        const val gradlePlugin = "com.android.tools.build:gradle:7.4.1"

        object AndroidX {

            object Core {
                private const val version = "1.10.1"
                const val coreKtx = "androidx.core:core-ktx:$version"
            }

            object AppCompat {
                private const val version = "1.6.1"
                const val appCompat = "androidx.appcompat:appcompat:$version"
            }

            object Fragment {
                private const val version = "1.5.7"
                const val fragmentKtx = "androidx.fragment:fragment-ktx:$version"
            }
        }
    }

    object Pyroman {

        object MvpKmp {
            private const val version = "1.0.0"
            const val mvpKmp = "ru.pyroman.mvpkmp:mvpkmp:$version"
        }

        object KmpSwiftPackage {
            private const val version = "1.0.0"
            const val kmpSwiftPackage = "ru.pyroman.kmp-swiftpackage:kmp-swiftpackage:$version"
        }
    }
}