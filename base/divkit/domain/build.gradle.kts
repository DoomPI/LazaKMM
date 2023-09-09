plugins {
    `multiplatform-setup`
    `android-setup`
}

kotlin {
    sourceSets {

        androidMain {
            dependencies {
                implementation(Dependencies.DivKit.data)
                implementation(Dependencies.DivKit.core)
                implementation(Dependencies.DivKit.json)
            }
        }

        commonMain {
            dependencies {
                useModule(ProjectModules.Common.core)
            }
        }
    }
}