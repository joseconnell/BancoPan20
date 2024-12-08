package com.example.bancopan20

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.bancopan20.R
import com.jconnell.bancopan20.R

class AdAdapter(private val adImages: List<Int>) : RecyclerView.Adapter<AdAdapter.AdViewHolder>() {

    // ViewHolder interno para mantener referencias a las vistas de cada ítem
    inner class AdViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val adImage: ImageView = itemView.findViewById(R.id.ad_image)
    }

    // Crea el ViewHolder inflando el diseño del ítem
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ad, parent, false)
        return AdViewHolder(view)
    }

    // Vincula los datos con las vistas del ViewHolder
    override fun onBindViewHolder(holder: AdViewHolder, position: Int) {
        if (position in adImages.indices) { // Validación para evitar errores de índice
            holder.adImage.setImageResource(adImages[position])
        }
    }

    // Devuelve el tamaño de la lista
    override fun getItemCount(): Int {
        return adImages.size
    }
}
