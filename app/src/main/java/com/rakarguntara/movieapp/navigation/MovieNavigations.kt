package com.rakarguntara.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.rakarguntara.movieapp.screens.detail.DetailScreens
import com.rakarguntara.movieapp.screens.home.HomeScreens

@Composable
fun MovieNavigations(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MovieScreens.HomeScreen.name){
        composable(MovieScreens.HomeScreen.name){
            HomeScreens(navController)
        }

        composable(MovieScreens.DetailScreen.name+"/{movie}", arguments = listOf(
            navArgument(name = "movie"){type = NavType.StringType}
        )){ backStackEntry ->
            DetailScreens(navController, backStackEntry.arguments?.getString("movie"))
        }
    }
}