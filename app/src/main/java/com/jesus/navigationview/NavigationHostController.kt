package com.jesus.navigationview

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.jesus.navigationview.screens.AddScreen
import com.jesus.navigationview.screens.DescriptionScreen
import com.jesus.navigationview.screens.HomeScreen

@Composable
fun NavigationHostController() {

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "Home",
        enterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(700)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(700)
            )
        },
        popEnterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(700)
            )
        },
        popExitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(700)
            )
        }
    ) {
        composable(route = RouteScreens.HomeScreen.route) { HomeScreen(navController) }
        composable(route = RouteScreens.AddScreen.route) { AddScreen(navController) }
        composable(
            route = "${RouteScreens.DescriptionScreen.route}/{userName}?phone={phone}",
            arguments = listOf(
                navArgument("userName") { type = NavType.StringType },
                navArgument("phone") { defaultValue = "Not phone" }
            )
        )
        {
            val userName = it.arguments?.getString("userName")
            val phone = it.arguments?.getString("phone")
            DescriptionScreen(navController, userName,phone)
        }
    }

}