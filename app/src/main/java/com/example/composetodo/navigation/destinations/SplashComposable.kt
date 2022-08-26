package com.example.composetodo.navigation.destinations

import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.composetodo.ui.screens.list.ListScreen
import com.example.composetodo.ui.screens.splash.SplashScreen
import com.example.composetodo.ui.viewmodels.SharedViewModel
import com.example.composetodo.util.Constants
import com.example.composetodo.util.toAction

fun NavGraphBuilder.splashComposable(
    navigateToListScreen: () -> Unit,
) {
    composable(
        route = Constants.SPLASH_SCREEN,
    ) {
        SplashScreen(navigateToListScreen = navigateToListScreen)
    }
}