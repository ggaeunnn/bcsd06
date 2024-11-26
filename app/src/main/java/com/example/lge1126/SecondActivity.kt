package com.example.lge1126

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val textViewRandomNumber: TextView = findViewById(R.id.textViewRandomNumber)
        val buttonBack: Button = findViewById(R.id.buttonBack)

        val count = intent.getIntExtra("COUNT", 0)
        val randomNumber = Random.nextInt(0, count + 1)
        textViewRandomNumber.text = "Here is a random number: $randomNumber"

        buttonBack.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra("RANDOM_NUMBER", randomNumber)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}
