package com.example.diceroller

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

/**Main Activity here
 *
 * */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
//        Do a dice roll when app starts
        rollDice()
    }

    @SuppressLint("SetTextI18n")
    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val luckyNumber = 6
        if (diceRoll == luckyNumber) {
            println("Hurray!")
        }
        val diceImage: ImageView = findViewById(R.id.imageView)
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        if (diceRoll == 6) {
            val resultTextView: TextView = findViewById(R.id.textView)
            resultTextView.text = "Hurray its a $diceRoll!"
            diceImage.setImageResource(drawableResource)
        }
        val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
        toast.show()
    }
}

/**
 * This is a simple class to generate Random Numbers for rolling a dice
 * */

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}