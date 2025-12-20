package io.github.agimaulana.boilerplate

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import io.agimaulana.github.boilerplate.core.design.theme.BoilerplateTheme
import io.agimaulana.github.boilerplate.feature.sample.navigateToSampleScreen
import io.agimaulana.github.boilerplate.feature.sample.sampleScreen

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoilerplateTheme {
                RootNavigation()
            }
        }
    }

}

@Composable
fun RootNavigation() {
    val rootNavController = rememberNavController()

    NavHost(navController = rootNavController, startDestination = "main_tabs") {
        composable("main_tabs") {
            MainScreen(
                onNavigateToSample = {
                    rootNavController.navigateToSampleScreen()
                }
            )
        }

        sampleScreen()
    }
}