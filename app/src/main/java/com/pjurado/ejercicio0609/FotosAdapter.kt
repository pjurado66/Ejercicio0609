package com.pjurado.ejercicio0609

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pjurado.ejercicio0609.databinding.ViewImagenBinding

class FotosAdapter(val fotos: List<String>, val listener: (String)->Unit) : RecyclerView.Adapter<FotosAdapter.ViewHolder>() {


    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val binding = ViewImagenBinding.bind(view)

        fun bind(foto: String) {
            Glide.with(binding.imagen)
                .load(foto)
                .centerCrop()
                .into(binding.imagen)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_imagen, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = fotos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(fotos[position])
        holder.itemView.setOnClickListener {
            listener(fotos[position])
        }
    }

}
