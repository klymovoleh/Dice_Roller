package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice objects with 6 and 20 sides and roll its
        val firstDice = Dice(6)
        val firstDiceRoll = firstDice.roll()

        // Update the screen with the dice roll
        var resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = firstDiceRoll.toString()
    }
}

/**
 * This activity allows the user to create new class (parent).
 */
class Dice(private val numSides: Int) {
    //Create new function - roll dice - random value from 1 to numSides.
    fun roll(): Int {
        return (1..numSides).random()
    }
}