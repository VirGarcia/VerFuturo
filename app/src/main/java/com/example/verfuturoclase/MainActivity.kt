package com.example.verfuturoclase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Cogemos las referencias de la UI
        val btnEnviar: Button = findViewById<Button>(R.id.btnEnviar)
        val txtNombre: EditText = findViewById(R.id.edTxtNombre)
        val calendario: DatePicker = findViewById<DatePicker>(R.id.datePickerBirthdate)

        // Programamos el botón
        btnEnviar.setOnClickListener{
            val nombre = txtNombre.text
            val dia = calendario.dayOfMonth
            val mes = calendario.month +1 // Los meses empiezan en 0
            val anio = calendario.year

            // Mostramos la fecha escogida
            Toast.makeText(this, "$nombre Fecha seleccionada: $dia/$mes/$anio", Toast.LENGTH_SHORT).show()

            // Para realizar el envío de información de una activity a la otr
            val intentFuturo = Intent(this, ActivityVerFuturo::class.java)
            // Añadir el nombre, el día y el mes de nacimiento como extras al Intent
            intentFuturo.putExtra("nombre", nombre.toString()) //Necesitamos hacerlo así
            intentFuturo.putExtra("dia", dia)
            intentFuturo.putExtra("mes", mes)
            startActivity(intentFuturo)
        }

    }

}