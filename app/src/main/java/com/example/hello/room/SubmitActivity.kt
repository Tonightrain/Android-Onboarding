package com.example.hello.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.widget.*
import com.example.hello.R
import com.example.hello.util.ErrorMessage
import database.AppDatabase
import entity.Person
import kotlin.concurrent.thread

class SubmitActivity : AppCompatActivity() {

    private val successMessage: String = "add succeeded"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit)

        val mGenderContainer = findViewById<LinearLayout>(R.id.gender_container)
        val mAgeContainer = findViewById<LinearLayout>(R.id.age_container)

        val submitButton = findViewById<Button>(R.id.button_submit)
        val nameEdit = findViewById<EditText>(R.id.edit_name)
        val genderEdit = findViewById<EditText>(R.id.edit_gender)
        val ageEdit = findViewById<EditText>(R.id.edit_age)

        val personDao = AppDatabase.getDatabase(this).personDao()
        submitButton.setOnClickListener {
            if (genderEdit.text.toString().toInt() != 0 && genderEdit.text.toString()
                    .toInt() != 1
            ) {
                Toast.makeText(this, ErrorMessage.GENDER_INVALID, Toast.LENGTH_SHORT).show()
            }
            if (ageEdit.text.toString().toInt() <= 0) {
                Toast.makeText(this, ErrorMessage.AGE_INVALID, Toast.LENGTH_SHORT).show()
            } else {
                thread {
                    val person = Person(
                        nameEdit.text.toString(),
                        genderEdit.text.toString().toInt(),
                        ageEdit.text.toString().toInt()
                    )
                    personDao.createPerson(person)
                }
                Toast.makeText(this, successMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun addTextView(content: String): TextView {
        val textView = TextView(this)
        textView.text = content
        return textView
    }
}