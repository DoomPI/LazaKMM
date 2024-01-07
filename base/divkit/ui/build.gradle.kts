plugins {
    `multiplatform-setup`
    `android-setup`
    kotlinSerialization
    `kotlin-parcelize`
    kotlinNativeCocoapods
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
            }
        }
    }

    cocoapods {
        name = "base-divkit-ui"
        summary = "Some description for the Divkit Module"
        homepage = "Link to the Divkit Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../../../iosApp/Podfile")
        framework {
            baseName = "BaseDivkitUi"
        }
    }
}