package com.vaskorr.testapp.presentation.di

import com.vaskorr.testapp.presentation.screen.main.MainViewModel
import com.vaskorr.testapp.presentation.screen.purchases.PurchasesViewModel
import com.vaskorr.testapp.presentation.screen.register.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module {
    viewModelOf(::MainViewModel)
    viewModelOf(::RegisterViewModel)
    viewModelOf(::PurchasesViewModel)
}