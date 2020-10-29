package com.example.hello.sharedPreference

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.hello.R

class SPActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_s_p)

        val spSaveButton = findViewById<Button>(R.id.sp_save_button)
        val spEdit = findViewById<EditText>(R.id.sp_edit)

        //读取数据
        val prefs = getSharedPreferences("data",Context.MODE_PRIVATE)
        val getContent = prefs.getString("editContent",null)
        spEdit.setText(getContent)

        //存数据
        spSaveButton.setOnClickListener {
            val editor = getSharedPreferences("data", Context.MODE_PRIVATE).edit()
            editor.putString("editContent", spEdit.text.toString())
            editor.apply()
        }
    }
}