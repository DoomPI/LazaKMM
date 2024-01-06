package ru.pyroman.laza.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import ru.pyroman.laza.base.divkit.ui.view.args.DivkitViewArgs
import ru.pyroman.laza.base.divkit.ui.view.fragment.DivkitFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val args = DivkitViewArgs(
            query = "product"
        )

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<DivkitFragment>(
                containerViewId = R.id.fragment_container,
                args = DivkitFragment.withArgs(args)
            )
        }
    }
}
