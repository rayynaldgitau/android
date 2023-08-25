package com.raynaldgitaz.augustmidmorningnavigationapp.ui.theme.pages.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.raynaldgitaz.augustmidmorningnavigationapp.ui.theme.AugustMidMorningNavigationAppTheme

@Composable
fun HomeScreen(navController:NavHostController) {
    Text(text = "Welcome to home screen ")
}

@Preview
@Composable
fun HomeScreenPreview() {
    AugustMidMorningNavigationAppTheme {
        HomeScreen(rememberNavController())
    }
}