package com.example.basictestapp.navigation

sealed class Screen(val route: String){
    object ONE: Screen("ONE")
    object TWO: Screen("TWO")
    object THREE: Screen("THREE"+ "/{key_name}"){
        fun getFullRoute(name: String): String {
            return "THREE/$name"
        }
    }
    object FOUR: Screen("FOUR")
}