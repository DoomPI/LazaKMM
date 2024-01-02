import org.kodein.di.DI
import org.kodein.di.direct
import ru.pyroman.laza.base.divkit.ui.divkitModule
import ru.pyroman.laza.common.core.coreModule
import ru.pyroman.laza.common.core.di.Inject
import ru.pyroman.laza.common.core.di.module
import ru.pyroman.laza.common.core.di.singleton
import ru.pyroman.laza.common.core.platform.PlatformConfiguration

object PlatformSDK {

    fun init(
        configuration: PlatformConfiguration
    ) {
        val platformModule = module("ru/pyroman/laza/common/core/platform") {
            singleton { configuration }
        }

        Inject.createDependencies(
            DI {
                importAll(
                    platformModule,
                    coreModule,
                    divkitModule,
                )
            }.direct
        )
    }
}