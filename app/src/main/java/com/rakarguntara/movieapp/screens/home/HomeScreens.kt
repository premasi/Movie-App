package com.rakarguntara.movieapp.screens.home

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.rakarguntara.movieapp.navigation.MovieScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreens(navController: NavController) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Movie App", style = TextStyle(
                    color = Color.White
                )
                ) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Red,
                ),
            )
        },
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(it)
        ) {
            Text(
                text = "List Movie",
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )
            MyContent(navController = navController)
        }
    }
}

@Composable
fun MyContent(
    navController: NavController,
    movieList: List<String> = listOf(
    "Agak Lain", "AsepTheDragon", "AsepPencilgon", "Gundam Seed", "Gundam", "Gundam Seed Destiny", "Kyoukai no Kanata"
)){
    val context = LocalContext.current
    Column(modifier = Modifier
        .padding(horizontal = 16.dp)
    ){
        LazyColumn{
            items(items = movieList){
                MovieItem(it){movie ->
                    Log.d("Asep Click", "MyContent: $movie")
                    navController.navigate(MovieScreens.DetailScreen.name)
                    Toast.makeText(context, movie, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

@Composable
fun MovieItem(title: String, onItemClick: (String) -> Unit = {}){
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(120.dp)
        .padding(bottom = 8.dp)
        .clickable {
            onItemClick(title)
        },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(10.dp)
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface (Modifier.padding(16.dp)
                .size(80.dp),
                shape = RectangleShape,
                shadowElevation = 4.dp){
                Icon(imageVector = Icons.Default.Add, contentDescription = "Movie",
                    tint = Color.Cyan)
            }
            Text(text = title, style = TextStyle(
                color = Color.Black
            ))
        }

    }
}
