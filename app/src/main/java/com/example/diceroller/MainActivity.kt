package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.diceroller.databinding.ActivityMainBinding // Importamos la clase generada de vinculación
import kotlin.random.Random

// https://classroom.udacity.com/courses/ud9012
// Actualizando con ConstraintLayout y View Binding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding // View Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener { rollDice() }

    }

    private fun rollDice() {

        /* Generación de números aleatorios (varias opciones equivalentes): */
        val randomInt = Random.nextInt(6) + 1
        val randomInt2 = Random.nextInt(1, 7) // Yo usaría ésta
        val randomInt3 = Random.nextInt(until = 7, from = 1) // (1)
        //val randomInt4  = Random.nextInt(7, 1) // (2)

        /* Seteo de la caja de texto con el número generado (para pruebas) */
        binding.textView.text = "$randomInt // $randomInt2 // $randomInt3"

        /* Seteo de la imagen correspondiente al número generado */
        binding.imageView.setImageResource(
            when (randomInt) {
                1 -> R.drawable.dice_1 // identificador (Int) referenciando recurso en "drawable"
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                6 -> R.drawable.dice_6
                else -> throw RuntimeException()
            }
        )

    }

}

/*
(1)
Kotlin permite indicar explícitamente el nombre del argumento que se pasa. Esto ayuda a la legibilidad
y permite pasarlos en cualquier orden (aunque lo normal será utilizar igualmente el orden habitual).
https://kotlinlang.org/docs/functions.html#named-arguments
https://en.wikipedia.org/wiki/Named_parameter

(2)
Si el límite superior es más bajo que el inferior, saltará un error en tiempo de ejecución.
 */