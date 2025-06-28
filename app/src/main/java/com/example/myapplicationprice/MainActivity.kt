package com.example.myapplicationprice

import androidx.compose.foundation.Image
import coil.compose.rememberAsyncImagePainter


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplicationprice.ui.theme.MyApplicationPriceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShopScreen()
                }
            }
        }


@Composable
fun ShopScreen(viewModel: ShopViewModel = viewModel()) {
    val items = viewModel.items

    if (items.isEmpty()) {
        Text(
            text = "No items loaded",
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        )
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(items) { item ->
                Text(
                    text = "${item.name} - ${item.price}",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                )
            }
        }
    }
}
