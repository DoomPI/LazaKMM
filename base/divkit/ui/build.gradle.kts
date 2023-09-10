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
                implementation(Dependencies.DivKit.core)
                implementation(Dependencies.DivKit.json)
            }
        }

        commonMain {
            dependencies {
                useModule(ProjectModules.Common.core)
                useModule(ProjectModules.Base.Divkit.domain)
                useModule(ProjectModules.Base.Uikit.uikit)
            }
        }
    }
}