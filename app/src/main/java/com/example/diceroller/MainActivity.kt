package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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

    fun rollDice() {

        /* Generación de números aleatorios (varias opciones equivalentes): */
        val randomInt  = Random.nextInt(6) + 1
        val randomInt2  = Random.nextInt(1,7) // Yo usaría ésta
        val randomInt3  = Random.nextInt(until = 7, from = 1)
        //val randomInt4  = Random.nextInt(7, 1)

        /* Seteo de la caja de texto con el número generado (para pruebas) */
        binding.textView.setText("$randomInt // $randomInt2 // $randomInt3")

        /* Seteo de la imagen correspondiente al número generado */
        val id_imagen = when(randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> throw Exception()   // TODO: revisar excepciones
        }
        binding.imageView.setImageResource(id_imagen)


    }

    // https://classroom.udacity.com/courses/ud9012/lessons/37a8fa57-7d18-4704-bfb7-da2864cb2e75/concepts/3e9c9714-eb89-438e-8a06-2a75dd9f3719



}