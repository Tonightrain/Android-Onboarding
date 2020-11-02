package com.example.hello.network

import retrofit2.http.GET
import retrofit2.Call

interface AppService {

    @GET("/fake-data/data/default.json")
    fun getAppData(): Call<App>
}


