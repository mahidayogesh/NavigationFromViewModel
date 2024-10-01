package com.demo.navigationfromviewmodel.ui.login

sealed interface LoginUiEvents {
    data object Login : LoginUiEvents
    data object Register : LoginUiEvents
}