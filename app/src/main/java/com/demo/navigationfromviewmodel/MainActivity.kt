package com.demo.navigationfromviewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.demo.navigationfromviewmodel.navigation.Destination
import com.demo.navigationfromviewmodel.navigation.NavigationAction
import com.demo.navigationfromviewmodel.navigation.Navigator
import com.demo.navigationfromviewmodel.navigation.ObserveAsEvents
import com.demo.navigationfromviewmodel.ui.details.DetailViewModel
import com.demo.navigationfromviewmodel.ui.details.DetailsComposable
import com.demo.navigationfromviewmodel.ui.home.HomeComposable
import com.demo.navigationfromviewmodel.ui.home.HomeViewModel
import com.demo.navigationfromviewmodel.ui.login.LoginComposable
import com.demo.navigationfromviewmodel.ui.login.LoginViewModel
import com.demo.navigationfromviewmodel.ui.register.RegisterComposable
import com.demo.navigationfromviewmodel.ui.register.RegisterNewViewModel
import com.demo.navigationfromviewmodel.ui.theme.NavigationFromViewModelTheme
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.koinInject
import java.util.UUID

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationFromViewModelTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    val navController = rememberNavController()
                    val navigator = koinInject<Navigator>()

                    ObserveAsEvents(flow = navigator.navigationActions) { action ->
                        when (action) {
                            is NavigationAction.Navigate -> navController.navigate(
                                action.destination
                            ) {
                                action.navOptions(this)
                            }

                            NavigationAction.NavigateUp -> navController.navigateUp()
                        }
                    }

                    NavHost(
                        navController = navController,
                        startDestination = navigator.startDestination,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        navigation<Destination.AuthGraph>(
                            startDestination = Destination.LoginScreen
                        ) {
                            composable<Destination.LoginScreen> {
                                val viewModel = koinViewModel<LoginViewModel>()
                                LoginComposable(viewModel = viewModel)
                            }
                            composable<Destination.RegisterScreen> {
                                val viewModel = koinViewModel<RegisterNewViewModel>()
                                RegisterComposable(viewModel = viewModel)
                            }
                        }
                        navigation<Destination.HomeGraph>(
                            startDestination = Destination.HomeScreen
                        ) {
                            composable<Destination.HomeScreen> {
                                val viewModel = koinViewModel<HomeViewModel>()
                                HomeComposable(viewModel = viewModel)
                            }
                            composable<Destination.DetailScreen> {
                                val viewModel = koinViewModel<DetailViewModel>()
                                val args = it.toRoute<Destination.DetailScreen>()
                                DetailsComposable(viewModel = viewModel, args = args)
                            }
                        }
                    }
                }
            }
        }
    }
}