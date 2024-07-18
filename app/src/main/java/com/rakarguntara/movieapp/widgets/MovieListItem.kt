package com.rakarguntara.movieapp.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.rakarguntara.movieapp.models.MovieData
import com.rakarguntara.movieapp.models.getMovieData

@Preview
@Composable
fun MovieListItem(data: MovieData = getMovieData()[0], onItemClick: (String) -> Unit = {}){
    val expendable = remember {
        mutableStateOf(false)
    }
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 8.dp)
        .clickable {
            onItemClick(data.id)
        },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(10.dp)
    ){
        Row(
            modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface (
                Modifier.padding(16.dp)
                .size(80.dp),
                shape = RectangleShape,
                shadowElevation = 4.dp){
                AsyncImage(model = data.images[0], contentDescription = "Images")
            }
            Column (modifier = Modifier.padding(start = 8.dp)){
                Text(text = data.title, style = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                ), modifier = Modifier.padding(bottom = 4.dp),)
                Text(text = "Genre: ${data.genre}", style = TextStyle(
                    color = Color.Black,
                    fontSize = 14.sp
                ), modifier = Modifier.padding(bottom = 4.dp))
                Text(text = "Released: ${data.year}", style = TextStyle(
                    color = Color.DarkGray,
                    fontSize = 12.sp
                ))
                AnimatedVisibility(visible = expendable.value){
                    Column (){
                        Text(buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = Color.DarkGray,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Light
                                )
                            ) {
                                append("Plot: ")
                            }
                            withStyle(
                                style = SpanStyle(
                                    color = Color.Gray,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Light
                                )
                            ) {
                                append(data.plot)
                            }
                        }, modifier = Modifier.padding(6.dp))
                        Divider(modifier = Modifier.padding(vertical = 8.dp))
                        Text(buildAnnotatedString {
                            withStyle(style = SpanStyle(
                                color = Color.DarkGray,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Light
                            )){
                                append("Director: ")
                            }
                            withStyle(style = SpanStyle(
                                color = Color.DarkGray,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Light
                            )){
                                append(data.director)
                            }
                        })
                        Text(buildAnnotatedString {
                            withStyle(style = SpanStyle(
                                color = Color.DarkGray,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Light
                            )){
                                append("Actors: ")
                            }
                            withStyle(style = SpanStyle(
                                color = Color.Blue,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Light
                            )){
                                append(data.actor)
                            }
                        })
                    }
                }

                Icon(imageVector = if(expendable.value) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = "Drop Icon",
                    modifier = Modifier
                        .size(25.dp)
                        .clickable {
                            expendable.value = !expendable.value
                    },
                    tint = Color.Blue
                )
            }

        }

    }
}