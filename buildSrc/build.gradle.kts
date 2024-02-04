plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    mavenLocal()
    google()
}

dependencies {
    implementation(Dependencies.Kotlin.gradlePlugin)
    implementation(Dependencies.Android.gradlePlugin)

    api(Dependencies.Pyroman.KmpSwiftPackage.kmpSwiftPackage)
}

kotlin {
    sourceSets.getByName("main").kotlin.srcDir("buildSrc/src/main/kotlin")
}

gradlePlugin {
    plugins {
        create("pluginMaven") {
            id = Plugins.Local.CommonModuleSetup.commonModuleSetup
            implementationClass = "plugins.CommonModuleSetupPlugin"
        }
    }
}