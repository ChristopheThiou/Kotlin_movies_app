package com.example.tp1_movie_app.navigation

import java.lang.IllegalArgumentException

enum class MovieScreens {
    HomeScreen, // => 0
    DetailsScreen; // => 1
    companion object { // block statics
        fun fromRoute(route: String?): MovieScreens
                = when(route?.substringBefore("/")){
            HomeScreen.name -> HomeScreen
            DetailsScreen.name -> DetailsScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognised")
        }
    }

}