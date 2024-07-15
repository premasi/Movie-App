package com.rakarguntara.movieapp.screens.home

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.rakarguntara.movieapp.models.MovieData
import com.rakarguntara.movieapp.models.getMovieData
import com.rakarguntara.movieapp.navigation.MovieScreens
import com.rakarguntara.movieapp.widgets.MovieListItem

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
    movieList: List<MovieData> = getMovieData()
){
    val context = LocalContext.current
    Column(modifier = Modifier
        .padding(horizontal = 16.dp)
    ){
        LazyColumn{
            items(items = movieList){
                MovieListItem(it){id ->
                    Log.d("Asep Click", "MyContent: ${id}")
                    navController.navigate(MovieScreens.DetailScreen.name+"/${it.id}")
                    Toast.makeText(context, it.id, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}


