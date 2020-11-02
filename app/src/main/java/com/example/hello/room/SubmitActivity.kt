package com.example.hello.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.*
import com.example.hello.R
import com.example.hello.util.ErrorMessage
import database.AppDatabase
import entity.Person
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

class SubmitActivity : AppCompatActivity() {

    private val successMessage: String = "add succeeded"
    private lateinit var submitButton:Button
    private lateinit var nameEdit:EditText
    private lateinit var genderEdit:EditText
    private lateinit var ageEdit:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit)

        submitButton = findViewById(R.id.button_submit)
        nameEdit = findViewById(R.id.edit_name)
        genderEdit = findViewById(R.id.edit_gender)
        ageEdit = findViewById(R.id.edit_age)

        val personDao = AppDatabase.getDatabase(this).personDao()
        submitButton.setOnClickListener {
            if (genderEdit.text.toString().toInt() != 0 && genderEdit.text.toString()
                    .toInt() != 1
            ) {
                genderEdit.error = ErrorMessage.GENDER_INVALID
            }
            if (ageEdit.text.toString().toInt() <= 0) {
                ageEdit.error = ErrorMessage.AGE_INVALID
            } else {
                GlobalScope.launch {
                    val person = Person(
                        nameEdit.text.toString(),
                        genderEdit.text.toString().toInt(),
                        ageEdit.text.toString().toInt()
                    )
                    personDao.createPerson(person)
                    Looper.prepare()
                    Toast.makeText(this@SubmitActivity, successMessage, Toast.LENGTH_SHORT).show()
                    Looper.loop()
                }

            }
        }
    }
}