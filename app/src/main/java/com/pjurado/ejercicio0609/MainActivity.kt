package com.pjurado.ejercicio0609

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.os.bundleOf
import com.pjurado.ejercicio0609.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
            recycler.adapter = FotosAdapter(fotos){ string ->
                val fragment = FotoFragment()
                fragment.arguments = bundleOf(FotoFragment.FOTO to string)
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_view, fragment)
                    .addToBackStack(null)
                    .commit()
            }
        }

    }

    private val fotos = (1..100).map{
        "https://picsum.photos/200/300?random=$it"
    }
}