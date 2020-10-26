package com.example.hello

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ActivityPracticesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practices)

        val buttonToContactPerson = findViewById<Button>(R.id.activity_practices)
        buttonToContactPerson.setOnClickListener{
            val intent = Intent()
            intent.setClass(this,ContactPersonActivity::class.java)
            startActivity(intent)
        }
    }
}