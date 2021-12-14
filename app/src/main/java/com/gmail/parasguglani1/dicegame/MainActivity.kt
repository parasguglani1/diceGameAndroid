package com.gmail.parasguglani1.dicegame

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rollDice()
        val rollButton: Button = findViewById(R.id.play_btn)
        rollButton.setOnClickListener {
//            Toast.makeText(this, "Dice rolled",Toast.LENGTH_SHORT).show()
            rollDice()
        }

    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val result1ImageView: ImageView = findViewById(R.id.dice1Result)
        result1ImageView.setImageResource(R.drawable.dice_2)
//        resultTextView.text = diceRoll.toString()
//        when (diceRoll) {
//            1 -> result1ImageView.setImageResource(R.drawable.dice_1)
//            2 -> result1ImageView.setImageResource(R.drawable.dice_2)
//            3 -> result1ImageView.setImageResource(R.drawable.dice_3)
//            4 -> result1ImageView.setImageResource(R.drawable.dice_4)
//            5 -> result1ImageView.setImageResource(R.drawable.dice_5)
//            6 -> result1ImageView.setImageResource(R.drawable.dice_6)
//        }

        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        result1ImageView.contentDescription = diceRoll.toString()
        result1ImageView.setImageResource(drawableResource)



    }


}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}