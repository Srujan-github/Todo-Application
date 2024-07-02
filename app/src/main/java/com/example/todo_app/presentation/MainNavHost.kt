package com.example.todo_app.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainAppNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MAIN_SCREEN) {
        composable(Screen.MAIN_SCREEN) {

        }
        composable(Screen.ADD_SCREEN) {

        }
        composable(Screen.DETAIL_SCREEN) {

        }
        composable(Screen.COMPLETED_SCREEN) {

        }
        composable(Screen.EDIT_SCREEN) {

        }
    }
}
object Screen{
    const val ADD_SCREEN = "add_screen"
    const val DETAIL_SCREEN = "detail_screen"
    const val EDIT_SCREEN = "edit_screen"
    const val COMPLETED_SCREEN = "completed_screen"
    const val MAIN_SCREEN = "main_screen"
}