package com.example.hello.kotlinCoroutines

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.hello.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class RxActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx2)

        val buttonTiming = findViewById<Button>(R.id.button_rx)
        buttonTiming.setOnClickListener {
            var count = 0
            GlobalScope.launch {
                repeat(11) {
                    if (count == 10) {
                        setIsEnabled(buttonTiming,true)
                    }else{
                        setIsEnabled(buttonTiming,false)
                    }
                    setText(buttonTiming, "The number is $count")
                    count++
                    delay(1000)
                }
            }
        }
    }

    private fun setText(text: TextView, value: String) {
        runOnUiThread { text.text = value }
    }

    private fun setIsEnabled(text: TextView,isButtonEnable:Boolean){
        runOnUiThread { text.isEnabled = isButtonEnable }
    }
}