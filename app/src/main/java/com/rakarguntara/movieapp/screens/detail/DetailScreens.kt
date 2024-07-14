package com.rakarguntara.movieapp.screens.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DetailScreens(navController: NavController, movieTitle: String?){
    Surface(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 16.dp, start = 16.dp)
    ){
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("$movieTitle", style = MaterialTheme.typography.titleLarge)
            Button(modifier = Modifier.padding(top = 8.dp),
                shape = RoundedCornerShape(8.dp),
                onClick = {
                    navController.popBackStack()
                }
            ){
                Text("Go Back")

            }
        }

    }

}