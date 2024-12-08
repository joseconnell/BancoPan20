package com.jconnell.bancopan20

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class emprestimoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emprestimo) // Asegúrate de que el nombre del layout sea correcto

        // Configurar el botón de retorno
        val btnRetorno: ImageView = findViewById(R.id.btn_retorno)
        btnRetorno.setOnClickListener {
            finish() // Finaliza la actividad actual y regresa a la anterior
        }
    }
}
