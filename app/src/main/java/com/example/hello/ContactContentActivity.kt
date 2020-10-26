package com.example.hello

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class ContactContentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_content)

        val imageOfJack = findViewById<ImageView>(R.id.person1)
        imageOfJack.setOnClickListener {
            val intent = Intent()
            val bundle = Bundle()
            bundle.putString("person content",getString(R.string.name_1)+' '+getString(R.string.phone_1))
            intent.putExtras(bundle)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }

        val imageOfMike = findViewById<ImageView>(R.id.person2)
        imageOfMike.setOnClickListener {
            val intent = Intent()
            val bundle = Bundle()
            bundle.putString("person content",getString(R.string.name_2)+' '+getString(R.string.phone_2))
            intent.putExtras(bundle)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }
}