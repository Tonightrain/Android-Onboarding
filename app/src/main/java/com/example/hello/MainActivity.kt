package com.example.hello

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.hello.architecture.ArchActivity
import com.example.hello.recyclerView.RecyclerViewActivity
import com.example.hello.fragment.FragmentActivity
import com.example.hello.kotlinCoroutines.RxActivity
import com.example.hello.network.NetworkActivity
import com.example.hello.room.SubmitActivity
import com.example.hello.room.ViewActivity
import com.example.hello.sharedPreference.SPActivity

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
        val spActivityButton = findViewById<Button>(R.id.button7)
        spActivityButton.setOnClickListener {
            val intent = Intent().setClass(this,SPActivity::class.java)
            startActivity(intent)
        }
        val submitActivityButton = findViewById<Button>(R.id.button8)
        submitActivityButton.setOnClickListener {
           val intent = Intent().setClass(this,SubmitActivity::class.java)
            startActivity(intent)
        }
        val viewActivityButton = findViewById<Button>(R.id.button9)
        viewActivityButton.setOnClickListener {
            val intent = Intent().setClass(this,ViewActivity::class.java)
            startActivity(intent)
        }
        val networkActivityButton = findViewById<Button>(R.id.button10)
        networkActivityButton.setOnClickListener {
            val intent = Intent().setClass(this,NetworkActivity::class.java)
            startActivity(intent)
        }
        val archActivityButton = findViewById<Button>(R.id.button11)
        archActivityButton.setOnClickListener {
            val intent = Intent().setClass(this,ArchActivity::class.java)
            startActivity(intent)
        }
    }
}