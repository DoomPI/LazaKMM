plugins {
    `android-setup`
    `multiplatform-setup`
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                useModule(ProjectModules.Common.core)

                useModule(ProjectModules.Base.Divkit.ui)

                useModule(ProjectModules.Feature.product)
            }
        }
    }
}