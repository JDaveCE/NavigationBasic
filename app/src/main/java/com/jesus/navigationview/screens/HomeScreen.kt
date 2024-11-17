package com.jesus.navigationview.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.jesus.navigationview.RouteScreens


@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun HomeScreen(navController: NavHostController) {

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                containerColor = Color.LightGray,
                onClick = {
                    navController.navigate(RouteScreens.AddScreen.route)
                }) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "Go Add Screen",
                    tint = Color.White
                )
            }
        },

        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.DarkGray
                ),
                title = { Text("Home", color = Color.White) }
            )
        }


    ) { paddingValues ->

        Column (
            modifier = Modifier.padding(paddingValues)
        ){
            NameElement("Jesus Contreras",navController)
            NameElement("Maria Lopez",navController)
        }

    }
}

@Composable
fun NameElement(name: String,navController: NavHostController){
    Text(
        text = name,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = Color.DarkGray,
        modifier = Modifier.padding(10.dp)
            .clickable { navController.navigate("${RouteScreens.DescriptionScreen.route}/$name?phone= +593 99 418 5620")}
    )
    HorizontalDivider()
}