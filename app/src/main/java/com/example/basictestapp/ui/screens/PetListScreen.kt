package com.example.basictestapp.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.basictestapp.data.module.Pet
import com.example.basictestapp.navigation.Screen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PetListScreen(navController: NavController){
    ProductListScreen(navController = navController)
}

@Composable
fun ProductListScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: PetsViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Box(modifier = modifier) {
        // If the error occurs
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }

        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        } else {
            LazyColumn{
                items(state.items){ pet->
                    PetListItem(pet, navController)
                }
            }
        }
    }
}

@Composable
fun PetListItem(pet: Pet, navController: NavController){
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)
        .border(border = BorderStroke(1.dp, Color.DarkGray), shape = RoundedCornerShape(20.dp))
        .clickable {
            navController.navigate(route = Screen.THREE.getFullRoute(name = pet.title))
        }




    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),

            ){


            AsyncImage(
                model = pet.imageUrl,
                contentDescription = pet.contentUrl,
                modifier = Modifier.size(150.dp)
            )
            Spacer(modifier = Modifier.size(10.dp))

            Text(
                text = pet.title,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 30.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
    }
}



