package com.jesus.navigationview

sealed class RouteScreens (val route: String) {
    data object HomeScreen : RouteScreens("Home")
    data object AddScreen : RouteScreens("Add")
    data object DescriptionScreen : RouteScreens("Description")

}