package com.example.basictestapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.basictestapp.ui.screens.PetListScreen
import com.example.basictestapp.ui.screens.NewsScreen
import com.example.basictestapp.ui.screens.ScreenThree


@Composable
fun setUpNavHost(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.ONE.route){
        composable(route = Screen.ONE.route){
            NewsScreen(navController)
        }
        composable(route = Screen.TWO.route){
            PetListScreen(navController)
        }
        composable(route = Screen.THREE.route,
            arguments = listOf(
                navArgument(name = "key_name") {
                    type = NavType.StringType
                }
            )){
                navBackStackEntry ->
            val name = navBackStackEntry.arguments?.getString("key_name")
            ScreenThree(navController,name = name)
        }

    }
}