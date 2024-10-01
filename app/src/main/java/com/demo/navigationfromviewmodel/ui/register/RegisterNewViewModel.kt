package com.demo.navigationfromviewmodel.ui.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.navigationfromviewmodel.navigation.Destination
import com.demo.navigationfromviewmodel.navigation.Navigator
import kotlinx.coroutines.launch

class RegisterNewViewModel(
    private val navigator: Navigator
) : ViewModel() {

    fun popup() {
        viewModelScope.launch {
            navigator.navigateUp()
        }
    }

    fun register() {
        viewModelScope.launch {
            navigator.navigate(Destination.HomeGraph)
        }
    }

}