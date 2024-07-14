package com.rakarguntara.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rakarguntara.movieapp.navigation.MovieNavigations
import com.rakarguntara.movieapp.ui.theme.MovieAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MovieNavigations()
            }
        }
    }
}


@Composable
fun MyApp(content: @Composable () -> Unit){
    MovieAppTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            content()

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MovieAppTheme {
        MyApp {
            MovieNavigations()
        }
    }
}