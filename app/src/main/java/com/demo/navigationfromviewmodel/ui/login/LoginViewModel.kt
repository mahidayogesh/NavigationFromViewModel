package com.demo.navigationfromviewmodel.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.navigationfromviewmodel.navigation.Destination
import com.demo.navigationfromviewmodel.navigation.Navigator
import kotlinx.coroutines.launch

class LoginViewModel(
    private val navigator: Navigator
) : ViewModel() {

    fun eventHandler(uiEvents: LoginUiEvents) {
        viewModelScope.launch {
            when (uiEvents) {
                LoginUiEvents.Login -> {
                    navigator.navigate(
                        destination = Destination.HomeGraph,
                        navOptions = {
                            popUpTo(Destination.AuthGraph) {
                                inclusive = true
                            }
                        }
                    )
                }

                LoginUiEvents.Register -> {
                    navigator.navigate(Destination.RegisterScreen)
                }

                else -> {

                }

            }

        }
    }
}