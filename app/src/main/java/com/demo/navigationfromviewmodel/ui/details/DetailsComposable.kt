package com.demo.navigationfromviewmodel.ui.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.demo.navigationfromviewmodel.navigation.Destination

@Composable
fun DetailsComposable(viewModel: DetailViewModel, args: Destination.DetailScreen) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "ID: ${args.id}")
        Button(onClick = viewModel::goBack) {
            Text(text = "Go back")
        }
    }

}