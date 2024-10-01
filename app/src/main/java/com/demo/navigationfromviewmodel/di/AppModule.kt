package com.demo.navigationfromviewmodel.di

import com.demo.navigationfromviewmodel.navigation.DefaultNavigator
import com.demo.navigationfromviewmodel.navigation.Destination
import com.demo.navigationfromviewmodel.ui.details.DetailViewModel
import com.demo.navigationfromviewmodel.ui.home.HomeViewModel
import com.demo.navigationfromviewmodel.ui.login.LoginViewModel
import com.demo.navigationfromviewmodel.navigation.Navigator
import com.demo.navigationfromviewmodel.ui.register.RegisterNewViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {

    single<Navigator> {
        DefaultNavigator(startDestination = Destination.AuthGraph)
    }

    viewModelOf(::LoginViewModel)
    viewModelOf(::HomeViewModel)
    viewModelOf(::DetailViewModel)
    viewModelOf(::RegisterNewViewModel)
}