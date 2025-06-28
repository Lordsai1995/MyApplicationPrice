package com.example.myapplicationprice

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ShopViewModel : ViewModel() {
    var items by mutableStateOf<List<ShopItem>>(emptyList())
        private set

    init {
        viewModelScope.launch {
            try {
                val result = RetrofitInstance.api.getItems()
                Log.d("MY_APP", "Fetched ${result.size} items")
                items = result
            } catch (e: Exception) {
                Log.e("MY_APP", "API Error: ${e.localizedMessage}")
            }
        }
    }

}
