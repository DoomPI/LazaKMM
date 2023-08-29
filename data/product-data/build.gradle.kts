plugins {
    `multiplatform-setup`
    `android-setup`
    kotlinSerialization
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {

                useCommonDataLibraries()
                useModule(ProjectModules.Common.core)
                useModule(ProjectModules.Domain.product)
            }
        }
    }
}