package com.example.verfuturoclase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class ActivityVerFuturo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_futuro)

        // Mapa para las imágenes del Zodiaco
        val recursosSigno = mapOf(
            "aries" to R.drawable.aries,
            "tauro" to R.drawable.tauro,
            "geminis" to R.drawable.geminis,
            "cancer" to R.drawable.cancer,
            "leo" to R.drawable.leo,
            "virgo" to R.drawable.virgo,
            "libra" to R.drawable.libra,
            "escorpio" to R.drawable.scorpio,
            "sagitario" to R.drawable.sagitario,
            "capricornio" to R.drawable.capricornio,
            "acuario" to R.drawable.acuario,
            "piscis" to R.drawable.piscis,
        )

        // Obtenemos los elementos gráficos
        val imgSigno = findViewById<ImageView>(R.id.imgSignoZodiaco)
        val txtPrediccion = findViewById<TextView>(R.id.txtFuturo)
        val btnVolver = findViewById<Button>(R.id.btnVolver)

        // Cuando se hace clic en el botón "Volver", simplemente llama a finish()
        btnVolver.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                finish()
            }
        })

        // Obtener el nombre, día y el mes de nacimiento del Intent
        val nombre = intent.getStringExtra("nombre") ?: "Nombre"
        val diaNacimiento = intent.getIntExtra("dia", -1)
        val mesNacimiento = intent.getIntExtra("mes", -1)

        //Creamos un objeto de la clase Oráculo y la predicción
        val oraculo = Oraculo(diaNacimiento, mesNacimiento)
        val prediccion = oraculo.obtenerPrediccion(nombre)

        // Mostramos la predicción en la UI y asignamos la imagen correcta al ImageView
        txtPrediccion.text = prediccion
        val signoId = recursosSigno[oraculo.signo] ?: 0
        val nuevoDrawable = getDrawable(signoId)
        imgSigno.setImageDrawable(nuevoDrawable)
    }

}