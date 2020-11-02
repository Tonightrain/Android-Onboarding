package com.example.hello.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import com.example.hello.R
import database.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

class ViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        val mContainer: LinearLayout = findViewById<LinearLayout>(R.id.container)
        val personDao = AppDatabase.getDatabase(this).personDao()

        GlobalScope.launch {
            for (person in personDao.getPersons()) {
                mContainer.addView(addTextView(person.name))
                mContainer.addView(addTextView(genderConvert(person.gender)))
                mContainer.addView(addTextView(person.age.toString()))
            }
        }
    }

    private fun addTextView(content: String): TextView {
        val textView = TextView(this)
        textView.text = content
        return textView
    }

    private fun genderConvert(gender:Int):String{
        return if (gender == 0){
            "female"
        }else{
            "male"
        }
    }
}