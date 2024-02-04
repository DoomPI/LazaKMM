package plugins

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.findByType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import ru.pyroman.kmpswiftpackage.SwiftPackageExtension
import java.io.File

open class CommonModuleSetupPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.pluginManager.apply(Plugins.Pyroman.KmpSwiftPackage.kmpSwiftPackage)
        project.extensions.create<CommonModuleExtension>(EXTENSION_NAME, project)
    }

    companion object {
        const val EXTENSION_NAME = "commonModuleSetup"
    }
}

open class CommonModuleExtension(val project: Project) {

    fun configureModule(name: String) {
        val moduleName = "${name}Common"

        project.extensions.findByType<KotlinMultiplatformExtension>()?.run {
            listOf(
                iosArm64(),
                iosX64(),
                iosSimulatorArm64(),
            ).forEach {
                it.binaries {
                    framework {
                        baseName = moduleName
                        isStatic = true
                    }
                }
            }
        }

        project.extensions.findByType<SwiftPackageExtension>()?.run {
            packageName(moduleName)
            swiftToolsVersion("5.3")
            targetPlatforms {
                iOS { v("14.1") }
            }
            distributionMode { local() }
            outputDirectory(File(project.projectDir, moduleName))
        }
    }
}