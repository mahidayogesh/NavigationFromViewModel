package com.demo.navigationfromviewmodel.ui.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun RegisterComposable(
    viewModel: RegisterNewViewModel
) {
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = {
            viewModel.popup()
        }) {
            Text(text = "Back")
        }

        Button(onClick = { viewModel.register() }) {
            Text(text = "Register")
        }
    }
}