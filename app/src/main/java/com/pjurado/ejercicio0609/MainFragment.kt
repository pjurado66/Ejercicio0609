package com.pjurado.ejercicio0609

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.pjurado.ejercicio0609.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentMainBinding.bind(view).apply {
            recycler.adapter= FotosAdapter(fotos) {
                val bundle = bundleOf(FotoFragment.FOTO to it)
                findNavController().navigate(
                    R.id.action_mainFragment_to_fotoFragment,
                    bundle
                )
            }
        }
    }

    private val fotos = (1..100).map{
        "https://picsum.photos/200/300?random=$it"
    }
}