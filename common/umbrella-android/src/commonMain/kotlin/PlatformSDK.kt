import ru.pyroman.laza.common.core.di.Inject
import org.kodein.di.DI
import org.kodein.di.direct
import ru.pyroman.laza.base.divkit.ui.divkitModule
import ru.pyroman.laza.common.core.coreModule
import ru.pyroman.laza.common.core.di.module
import ru.pyroman.laza.common.core.di.singleton
import ru.pyroman.laza.common.core.platform.PlatformConfiguration
import ru.pyroman.laza.data.product.productDataModule
import ru.pyroman.laza.domain.product.productDomainModule

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
                    productDomainModule,
                    productDataModule,
                )
            }.direct
        )
    }
}