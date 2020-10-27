package com.example.hello.recyclerView

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.hello.R

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val recyclerListButton = findViewById<Button>(R.id.recycler_view_button)
        recyclerListButton.setOnClickListener {
            val intent = Intent().setClass(this,RecyclerLIstActivity::class.java)
            startActivity(intent)
        }
    }
}