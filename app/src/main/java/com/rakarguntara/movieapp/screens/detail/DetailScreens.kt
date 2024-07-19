package com.rakarguntara.movieapp.screens.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.rakarguntara.movieapp.models.getMovieData
import com.rakarguntara.movieapp.widgets.ListImageHorizontal
import com.rakarguntara.movieapp.widgets.MovieListItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreens(navController: NavController, id: String?){
    val data = getMovieData().filter {
        it.id == id
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start) {
                        Icon(
                            modifier = Modifier
                                .clickable {
                                    navController.popBackStack()
                                },
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "back",
                            tint = Color.White,)

                        Text("Detail", style = TextStyle(
                            color = Color.White
                        ))
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Red
                ))
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(it)
                .padding(horizontal = 16.dp, vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
            ) {
            MovieListItem(data[0])
            Divider(modifier = Modifier.padding(vertical = 16.dp))
            ListImageHorizontal(data)
        }
    }
}

