package com.vaskorr.testapp.domain.di

import com.vaskorr.testapp.domain.usecase.data.GetPurchasesUseCase
import com.vaskorr.testapp.domain.usecase.user.GetUserUseCase
import com.vaskorr.testapp.domain.usecase.user.SaveUserUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetUserUseCase(get()) }
    factory { SaveUserUseCase(get()) }
    factory { GetPurchasesUseCase(get()) }
}