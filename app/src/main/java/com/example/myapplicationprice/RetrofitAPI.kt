package com.example.myapplicationprice


import retrofit2.http.GET

interface ShopApiService {
    @GET("\"f364a168-f62d-40b0-bb4b-b18c2f885d4b") // 🔁 Replace "items" with your actual endpoint
    suspend fun getItems(): List<ShopItem>
}