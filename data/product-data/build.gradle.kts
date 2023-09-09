plugins {
    `multiplatform-setup`
    `android-setup`
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                useModule(ProjectModules.Common.core)
                useModule(ProjectModules.Base.Divkit.domain)
                useModule(ProjectModules.Base.Divkit.data)
                useModule(ProjectModules.Domain.product)
            }
        }
    }
}