package com.example.bancopan20

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.bancopan20.adapters.AdAdapter
import com.jconnell.bancopan20.R

class MainActivity : AppCompatActivity() {

    private var isNameVisible = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencias a los elementos del layout
        val imgPerfil: ImageView = findViewById(R.id.img_perfil)
        val edtNome: EditText = findViewById(R.id.edt_nome)
        val icVisibilidade: ImageView = findViewById(R.id.ic_visibilidade)
        val icAjuda: ImageView = findViewById(R.id.ic_ajuda)
        val icPix: ImageView = findViewById(R.id.ic_pix)
        val icPagamentos: ImageView = findViewById(R.id.ic_pagamentos)
        val icShoppingPan: ImageView = findViewById(R.id.ic_shopping_pan)
        val icEmprestimos: ImageView = findViewById(R.id.ic_emprestimos)
        val viewPager: ViewPager2 = findViewById(R.id.viewPager)

        // Botón para ir a CartaoActivity
        val btnIrACartao: ImageView = findViewById(R.id.btn_ir_a_cartao)
        btnIrACartao.setOnClickListener {
            val intent = Intent(this, CartaoActivity::class.java)
            intent.putExtra("clienteNombre", edtNome.text.toString())
            startActivity(intent)
        }

        // Evento de clic en la imagen del perfil
        imgPerfil.setOnClickListener {
            Toast.makeText(this, "Imagen del perfil seleccionada", Toast.LENGTH_SHORT).show()
        }

        // Evento para alternar visibilidad del nombre
        icVisibilidade.setOnClickListener {
            isNameVisible = !isNameVisible
            toggleNameVisibility(edtNome)
        }

        // Evento de clic en el ícono de ayuda
        icAjuda.setOnClickListener {
            Toast.makeText(this, "Ayuda seleccionada", Toast.LENGTH_SHORT).show()
        }

        // Clics en botones de funcionalidades
        setupFunctionalIcons(icPix, "Funcionalidad PIX")
        setupFunctionalIcons(icPagamentos, "Funcionalidad Pagamentos")
        setupFunctionalIcons(icShoppingPan, "Funcionalidad Shopping PAN")
        setupFunctionalIcons(icEmprestimos, "Funcionalidad Empréstimos")

        // Configuración del ViewPager2
        setupViewPager(viewPager)
    }

    private fun toggleNameVisibility(edtNome: EditText) {
        if (isNameVisible) {
            edtNome.hint = "Nombre del Cliente"
            edtNome.setTextColor(ContextCompat.getColor(this, R.color.black))
            Toast.makeText(this, "Nombre visible", Toast.LENGTH_SHORT).show()
        } else {
            edtNome.hint = "Oculto"
            edtNome.text.clear()
            edtNome.setTextColor(ContextCompat.getColor(this, R.color.gray))
            Toast.makeText(this, "Nombre oculto", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupFunctionalIcons(icon: ImageView, message: String) {
        icon.setOnClickListener {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupViewPager(viewPager: ViewPager2) {
        // Lista de imágenes para los banners
        val banners = listOf(
            R.drawable.ad1, // Banner 1
            R.drawable.ad2, // Banner 2
            R.drawable.ad3  // Banner 3
        )

        // Configuración del adaptador
        val adAdapter = AdAdapter(banners)
        viewPager.adapter = adAdapter
    }
}
