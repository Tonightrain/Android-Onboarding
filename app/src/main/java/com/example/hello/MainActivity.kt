package com.example.hello

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val constraintButton = findViewById<Button>(R.id.button1)
        constraintButton.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, ConstraintActivity::class.java)
            startActivity(intent)
        }
        val loginButton = findViewById<Button>(R.id.button2)
        loginButton.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}