object ProjectModules {

    object Base {
        private const val base = ":base"

        object Divkit {
            private const val divkit = "$base:divkit"
            const val ui = "$divkit:ui"
            const val data = "$divkit:data"
            const val domain = "$divkit:domain"
        }

        object Uikit {
            const val uikit = "$base:uikit"
        }
    }

    object Common {
        private const val common = ":common"
        const val core = "$common:core"
        const val umbrellaAndroid = "$common:umbrella-android"
    }

    object Feature {
        private const val feature = ":feature"
        const val product = "$feature:product-feature"
    }

    object Domain {
        private const val domain = ":domain"
        const val product = "$domain:product-domain"
    }

    object Data {
        private const val data = ":data"
        const val product = "$data:product-data"
    }
}