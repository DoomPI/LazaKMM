plugins {
    `multiplatform-setup`
    `android-setup`
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                useCommonDomainLibraries()
                useModule(ProjectModules.Common.core)
            }
        }
    }
}