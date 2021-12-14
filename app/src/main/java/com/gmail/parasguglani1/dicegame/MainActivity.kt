package com.gmail.parasguglani1.dicegame

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = intent
        val name11 = intent.getStringExtra("player1name")
        val name12 = intent.getStringExtra("player2name")
        val won = rollDice()
        val rollButton: Button = findViewById(R.id.play_btn)
        val player1TextView: TextView = findViewById(R.id.player1name)
        val player2TextView: TextView = findViewById(R.id.player2name)
        val drawCountTextView: TextView = findViewById(R.id.drawCount)
        var player1counter = 0
        var player2counter = 0
        var drawCounter = 0

        player1TextView.text = name11
        player2TextView.text = name12
        drawCountTextView.text = "Draw " + drawCounter



        val result1TextView: TextView = findViewById(R.id.resultText)
        val vsTag = "$name11 Vs $name12"
        result1TextView.text= vsTag


//            val won = rollDice()
        if(won=="player1")

        {
            result1TextView.text = name11 + " won"
            player1counter++
            player1TextView.text = name11 +" " + player1counter
            player2TextView.text = name12 + " " + player2counter
            drawCountTextView.text = "Draw " + drawCounter



        }
        else if (won== "player2")
        {
            result1TextView.text = name12 + " won"
            player2counter++
            player1TextView.text = name11 +" " + player1counter
            player2TextView.text = name12 + " " + player2counter
            drawCountTextView.text = "Draw " + drawCounter

        }
        else
        {
            result1TextView.text = "Draw"
            drawCounter++
            drawCountTextView.text = "Draw " + drawCounter
        }


        rollButton.setOnClickListener {
//            Toast.makeText(this, "Dice rolled",Toast.LENGTH_SHORT).show()

            val result1TextView: TextView = findViewById(R.id.resultText)
            val won = rollDice()
            if(won=="player1")

            {
                result1TextView.text = name11 + " won"
                player1counter++
                player1TextView.text = name11 +" " + player1counter
                player2TextView.text = name12 + " " + player2counter
            }
            else if (won== "player2")
            {
                result1TextView.text = name12 + " won"
                player2counter++
                player1TextView.text = name11 +" " + player1counter
                player2TextView.text = name12 + " " + player2counter

            }
            else
            {
                result1TextView.text = "Draw"
                drawCounter++
                drawCountTextView.text = "Draw " + drawCounter
            }

        }


    }

    private fun rollDice() : String {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val result1ImageView: ImageView = findViewById(R.id.dice1Result)
        val dice2 = Dice(6)
        val diceRoll2 = dice.roll()
        val result2ImageView: ImageView = findViewById(R.id.dice2Result)



        result1ImageView.setImageResource(R.drawable.dice_2)
        result1ImageView.setImageResource(R.drawable.dice_3)
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

        val drawableResource2 = when (diceRoll2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        result2ImageView.contentDescription = diceRoll.toString()
        result2ImageView.setImageResource(drawableResource2)


        if (diceRoll>diceRoll2)
        {
            return "player1"
        }
        else if (diceRoll<diceRoll2)
        {
            return "player2"

        }

        else
        {
            return "draw"
        }

    }


}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}