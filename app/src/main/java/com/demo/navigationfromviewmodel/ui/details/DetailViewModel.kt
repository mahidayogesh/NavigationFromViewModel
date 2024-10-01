package com.demo.navigationfromviewmodel.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.navigationfromviewmodel.navigation.Navigator
import kotlinx.coroutines.launch

class DetailViewModel(
    private val navigator: Navigator
): ViewModel() {

    fun goBack() {
        viewModelScope.launch {
            navigator.navigateUp()
        }
    }
}