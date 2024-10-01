package com.demo.navigationfromviewmodel.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.navigationfromviewmodel.navigation.Destination
import com.demo.navigationfromviewmodel.navigation.Navigator
import kotlinx.coroutines.launch

class HomeViewModel(
    private val navigator: Navigator
) : ViewModel() {

    fun navigateToDetail(id: String) {
        viewModelScope.launch {
            navigator.navigate(
                destination = Destination.DetailScreen(id),
            )
        }
    }

    fun login() {
        viewModelScope.launch {
            navigator.navigate(Destination.RegisterScreen)
        }
    }
}