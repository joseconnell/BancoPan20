package com.example.bancopan20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.example.bancopan20.adapters.AdvertisementPagerAdapter
import com.jconnell.bancopan20.R

class CartaoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cartao)

        // Referencia a la ViewPager para la publicidad
        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        val advertisementAdapter = AdvertisementPagerAdapter(getAdvertisements())
        viewPager.adapter = advertisementAdapter

        // Botón de volver
        val imgBack: ImageView = findViewById(R.id.img_back)
        imgBack.setOnClickListener {
            finish() // Regresa a la actividad anterior
        }

        // Botón de ayuda
        val imgHelp: ImageView = findViewById(R.id.img_help)
        imgHelp.setOnClickListener {
            // Acción para la ayuda (puede ser un Toast o navegación)
        }

        // Ejemplo de acción para un botón del layout
        val txtRequestCard: TextView = findViewById(R.id.txt_request_card)
        txtRequestCard.setOnClickListener {
            // Navegar a otra pantalla o ejecutar lógica
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getAdvertisements(): List<String> {
        // Aquí agregas las URLs de las imágenes o datos para el ViewPager
        return listOf(
            "https://example.com/ad1.jpg",
            "https://example.com/ad2.jpg",
            "https://example.com/ad3.jpg"
        )
    }
}
