package com.demo.navigationfromviewmodel.ui.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun LoginComposable(viewModel: LoginViewModel) {

    val eventHandler = viewModel::eventHandler

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            eventHandler(LoginUiEvents.Login)
        }) {
            Text(text = "Login")
        }
        Button(onClick = {
            eventHandler(LoginUiEvents.Register)
        }) {
            Text(text = "Register")
        }

    }

}