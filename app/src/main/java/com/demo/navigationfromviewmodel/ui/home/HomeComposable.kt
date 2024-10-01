package com.demo.navigationfromviewmodel.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import java.util.UUID

@Composable
fun HomeComposable(viewModel: HomeViewModel) {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            viewModel.navigateToDetail(UUID.randomUUID().toString())
        }) {
            Text(text = "Go to detail")
        }

        Button(onClick = { viewModel.login() }) {
            Text(text = "Login")
        }
    }

}