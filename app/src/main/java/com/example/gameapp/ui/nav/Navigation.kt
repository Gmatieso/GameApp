package com.example.gameapp.ui.nav

import com.example.gameapp.util.Constants.Screens.DETAIL_SCREEN
import com.example.gameapp.util.Constants.Screens.HOME_SCREEN

sealed class Screens (val route: String) {
    object  Home: Screens(route = HOME_SCREEN)
    object  Details: Screens(route = DETAIL_SCREEN)
}