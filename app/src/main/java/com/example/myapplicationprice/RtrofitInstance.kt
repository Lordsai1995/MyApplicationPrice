package com.example.myapplicationprice

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://mocki.io/v1/") // 👉 Replace this with real or mock URL
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: ShopApiService by lazy {
        retrofit.create(ShopApiService::class.java)
    }
}

