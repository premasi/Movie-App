package com.rakarguntara.movieapp.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.rakarguntara.movieapp.models.MovieData

@Composable
fun ListImageHorizontal(data: List<MovieData>) {
    LazyRow(
        modifier = Modifier
            .padding(vertical = 16.dp),
    ) {
        items(data[0].images) { image ->
            Card(
                modifier = Modifier.size(200.dp)
                    .padding(end = 16.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    AsyncImage(
                        model = image, contentDescription = "images",
                        modifier = Modifier.padding(16.dp)
                    )
                }

            }
        }
    }
}