package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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

        // Do a dice roll when the app starts
        rollDice()
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 side and roll it
        val dice = Dice(6)
        val firstDiceRoll = dice.roll()
        val secondDiceRoll = dice.roll()

        // Find the ImageView in the layout
        val firstDiceImage: ImageView = findViewById(R.id.imageView)
        val secondDiceImage: ImageView = findViewById(R.id.imageView2)

        // Update the ImageView with the correct drawable resource ID
        firstDiceImage.setImageResource(numOfSide(firstDiceRoll))
        secondDiceImage.setImageResource(numOfSide(secondDiceRoll))

        // Update the content description
        firstDiceImage.contentDescription = firstDiceRoll.toString()
        secondDiceImage.contentDescription = secondDiceRoll.toString()
    }
}

// Determine which drawable resource ID to use based on the dice roll
private fun numOfSide(number: Int): Int {
    return when (number) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
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