object ProjectModules {

    object Base {
        private const val base = ":base"
        const val uikit = "$base:uikit"
        const val divkit = "$base:divkit"
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