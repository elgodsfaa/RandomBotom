package com.godsfa.randomnumber

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val numeroAleatorio = Random.nextInt(1, 101)
        val numeroIntroducido = findViewById<EditText>(R.id.Texto)
        val boton = findViewById<Button>(R.id.miBoton)
        val mensaje = findViewById<TextView>(R.id.miMensaje)
        var contador = 0


        boton.setOnClickListener {
            val textoIngresado = numeroIntroducido.text.toString().toIntOrNull()

            if (textoIngresado == null || textoIngresado !in 1..100) {
                // Aquí salta el error, pero NO borramos el texto para que el aviso se quede en pantalla
                numeroIntroducido.error = "El número debe estar entre 1 y 100"
            } else {
                contador++
                val textoMensaje = when {
                    textoIngresado < numeroAleatorio -> "El número secreto es mayor. (llevas $contador intentos)"
                    textoIngresado > numeroAleatorio -> "El número secreto es menor. (llevas $contador intentos)"
                    else -> "¡Felicidades! Has ganado en $contador intentos"
                }
                mensaje.text = textoMensaje
                numeroIntroducido.text.clear()
            }
        }
    }
}