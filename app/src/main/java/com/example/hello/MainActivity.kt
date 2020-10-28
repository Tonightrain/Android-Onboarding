package com.example.hello

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.hello.recyclerView.RecyclerViewActivity
import com.example.hello.fragment.FragmentActivity
import com.example.hello.kotlinCoroutines.RxActivity

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
        val fragmentButton = findViewById<Button>(R.id.button4)
        fragmentButton.setOnClickListener {
            val intent = Intent().setClass(this,FragmentActivity::class.java)
            startActivity(intent)
        }
        val recyclerViewButton = findViewById<Button>(R.id.button5)
        recyclerViewButton.setOnClickListener {
            val intent = Intent().setClass(this,RecyclerViewActivity::class.java)
            startActivity(intent)
        }
        val rxActivityButton = findViewById<Button>(R.id.button6)
        rxActivityButton.setOnClickListener {
            val intent = Intent().setClass(this,RxActivity::class.java)
            startActivity(intent)
        }
    }
}