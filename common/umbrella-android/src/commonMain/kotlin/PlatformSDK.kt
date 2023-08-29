import ru.pyroman.laza.common.core.di.Inject
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.direct
import org.kodein.di.singleton
import ru.pyroman.laza.common.core.coreModule
import ru.pyroman.laza.common.core.platform.PlatformConfiguration
import ru.pyroman.laza.data.product.productDataModule
import ru.pyroman.laza.domain.product.productDomainModule

object PlatformSDK {

    fun init(
        configuration: PlatformConfiguration
    ) {
        val platformModule = DI.Module("ru/pyroman/laza/common/core/platform") {
            bind<PlatformConfiguration>() with singleton { configuration }
        }

        Inject.createDependencies(
            DI {
                importAll(
                    platformModule,
                    coreModule,
                    productDomainModule,
                    productDataModule,
                )
            }.direct
        )
    }
}