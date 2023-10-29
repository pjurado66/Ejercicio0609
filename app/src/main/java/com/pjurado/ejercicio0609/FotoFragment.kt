package com.pjurado.ejercicio0609

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.pjurado.ejercicio0609.databinding.FragmentFotoBinding


class FotoFragment : Fragment(R.layout.fragment_foto) {
    companion object {
        val FOTO= "foto"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentFotoBinding.bind(view).apply {
            val foto = arguments?.getString(FOTO)
            Glide.with(imagen)
                .load(foto)
                .centerCrop()
                .into(imagen)
        }
    }
}