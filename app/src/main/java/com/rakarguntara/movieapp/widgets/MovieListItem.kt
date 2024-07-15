package com.rakarguntara.movieapp.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.rakarguntara.movieapp.models.MovieData

@Composable
fun MovieListItem(data: MovieData, onItemClick: (String) -> Unit = {}){
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(120.dp)
        .padding(bottom = 8.dp)
        .clickable {
            onItemClick(data.id)
        },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(10.dp)
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface (
                Modifier.padding(16.dp)
                .size(80.dp),
                shape = RectangleShape,
                shadowElevation = 4.dp){
                Icon(imageVector = Icons.Default.Add, contentDescription = "Movie",
                    tint = Color.Cyan)
            }
            Text(text = data.title, style = TextStyle(
                color = Color.Black
            )
            )
        }

    }
}