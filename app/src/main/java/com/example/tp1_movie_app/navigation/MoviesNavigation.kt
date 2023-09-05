package com.example.tp1_movie_app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tp1_movie_app.screens.details.DetailsScreen
import com.example.tp1_movie_app.screens.home.HomeScreen

@Composable
fun MovieNavigation(){
    val navController = rememberNavController()
    // Pile (Retour) de composables qui composent les écrans de votre application ainsi que l'état de chaque ecran
    NavHost(navController = navController, startDestination = MovieScreens.HomeScreen.name){
        composable(MovieScreens.HomeScreen.name){ // "HomeScreen"
            HomeScreen(navController = navController)
        }
        composable(MovieScreens.DetailsScreen.name){
            DetailsScreen(navController = navController)
        }
    }
}