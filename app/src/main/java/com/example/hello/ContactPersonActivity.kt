package com.example.hello

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class ContactPersonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_person)

        val choosePersonButton = findViewById<Button>(R.id.choose_person)
        choosePersonButton.setOnClickListener {
            val intent = Intent()
            intent.action = "android.intent.action.content"
            startActivityForResult(intent,0)
        }

        val lifecycleButton = findViewById<Button>(R.id.lifecycle)
        lifecycleButton.setOnClickListener {
            val intent = Intent().setClass(this,LifecycleActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data != null) {
            Toast.makeText(this, data.extras?.getString("person content"),Toast.LENGTH_LONG).show()
        }
    }
}