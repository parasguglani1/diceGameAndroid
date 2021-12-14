package com.gmail.parasguglani1.dicegame

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class Input : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        val mname1: EditText = findViewById(R.id.editTextPersonName1)
        val mname2: EditText = findViewById(R.id.editTextPersonName2)

        val name1 = mname1.text
        val name2 = mname2.text



        val playButton: Button = findViewById(R.id.play_btn2)
        playButton.setOnClickListener {
//            Toast.makeText(this,name2,Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, MainActivity::class.java))




        }



    }
}