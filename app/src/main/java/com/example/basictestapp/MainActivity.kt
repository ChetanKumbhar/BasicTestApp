package com.example.basictestapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.basictestapp.navigation.setUpNavHost
import com.example.basictestapp.ui.theme.BasicTestAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicTestAppTheme {
                setUpNavHost()
            }
        }
    }
}