package com.example.hello

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.widget.Button
import android.widget.LinearLayout
import androidx.core.content.res.ColorStateListInflaterCompat.inflate
import com.google.android.material.button.MaterialButton

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
        val activityButton = findViewById<Button>(R.id.button3)
        activityButton.setOnClickListener {
            val intent = Intent(this, ActivityPracticesActivity::class.java)
            startActivity(intent)
        }

    }
}