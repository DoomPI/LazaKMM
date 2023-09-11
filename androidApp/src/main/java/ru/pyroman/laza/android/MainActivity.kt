package ru.pyroman.laza.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import ru.pyroman.laza.feature.product.view.ProductFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<ProductFragment>(R.id.fragment_container)
            }
        }

    }
}
