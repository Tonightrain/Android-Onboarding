package com.example.hello

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlin.math.log

class LifecycleActivity : AppCompatActivity() {
    private val tag = "Lifecycle"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)
        Log.d(tag, "--------onCreate--------")
    }

    override fun onStart() {
        super.onStart()
        Log.d(tag, "--------onStart--------")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag, "--------onResume--------")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag, "--------onPause--------")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(tag, "--------onRestart--------")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag, "--------onStop--------")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag, "--------onDestroy--------")
    }


}