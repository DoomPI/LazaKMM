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
        const val navigation = "$common:navigation"
        const val umbrella = "$common:umbrella"
    }

    object Feature {
        private const val feature = ":feature"
    }
}