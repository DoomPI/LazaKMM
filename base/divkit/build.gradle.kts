plugins {
    `multiplatform-setup`
    `android-setup`
    kotlinSerialization
}

kotlin {
    sourceSets {

        androidMain {
            dependencies {
                useBaseUIAndroidLibraries()

                implementation(Dependencies.DivKit.div)
                implementation(Dependencies.DivKit.data)
                implementation(Dependencies.DivKit.core)
                implementation(Dependencies.DivKit.json)
            }
        }

        commonMain {
            dependencies {
                useModule(ProjectModules.Common.core)
                shareModule(ProjectModules.Base.uikit)
            }
        }
    }
}