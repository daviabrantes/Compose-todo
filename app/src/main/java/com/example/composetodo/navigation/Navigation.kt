package com.example.composetodo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.composetodo.navigation.destinations.listComposable
import com.example.composetodo.navigation.destinations.taskComposable
import com.example.composetodo.ui.viewmodels.SharedViewModel
import com.example.composetodo.util.Constants.LIST_SCREEN

@Composable
fun setupNavigation(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    val screen = remember(navController) {
        Screens(navController = navController)
    }

    NavHost(navController = navController, startDestination = LIST_SCREEN) {
        listComposable(
            navigateToTaskScreen = screen.task,
            sharedViewModel = sharedViewModel
        )
        taskComposable(navigateToListScreen = screen.list)
    }
}