package com.example.hello.network

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.example.hello.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NetworkActivity : AppCompatActivity() {

    private lateinit var retrofitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network)

        retrofitButton = findViewById(R.id.retrofit_button)
        retrofitButton.setOnClickListener {
            val appService = ServiceCreator.create(AppService::class.java)

            appService.getAppData().enqueue(object : Callback<App> {
                override fun onResponse(call: Call<App>, response: Response<App>) {
                    val appData = response.body()
                    if (appData != null) {
                        Log.d("TAG", appData.data.toString())
                    }
                    Toast.makeText(this@NetworkActivity, "Succeeded", Toast.LENGTH_SHORT)
                        .show()
                }

                override fun onFailure(call: Call<App>, t: Throwable) {
                    Toast.makeText(this@NetworkActivity, "Error Occurred", Toast.LENGTH_SHORT)
                        .show()
                }
            })
        }
    }
}



