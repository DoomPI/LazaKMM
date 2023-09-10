plugins {
    `multiplatform-setup`
    `android-setup`
}

kotlin {
    sourceSets {

        androidMain {
            dependencies {
                useBaseUIAndroidLibraries()
            }
        }

        commonMain {
            dependencies {
                useModule(ProjectModules.Common.core)
            }
        }
    }
}