plugins {
    `multiplatform-setup`
    `android-setup`
    kotlinSerialization
    `kotlin-parcelize`
    commonModuleSetup
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
                useModule(ProjectModules.Common.navigation)
                useModule(ProjectModules.Base.Divkit.domain)
                useModule(ProjectModules.Base.Divkit.data)
                useModule(ProjectModules.Base.Uikit.uikit)

                implementation(Dependencies.Pyroman.MvpKmp.mvpKmp)
            }
        }
    }
}

commonModuleSetup {
    configureModule("BaseDivkitUi")
}