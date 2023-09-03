plugins {
    `android-setup`
    `multiplatform-setup`
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                useModule(ProjectModules.Common.core)

                useModule(ProjectModules.Base.divkit)

                useModule(ProjectModules.Data.product)

                useModule(ProjectModules.Domain.product)

                useModule(ProjectModules.Feature.product)
            }
        }
    }
}