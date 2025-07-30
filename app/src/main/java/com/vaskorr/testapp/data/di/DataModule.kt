package com.vaskorr.testapp.data.di

import com.vaskorr.testapp.data.DataRepositoryImpl
import com.vaskorr.testapp.data.UserRepositoryImpl
import com.vaskorr.testapp.data.local.JsonDataProvider
import com.vaskorr.testapp.data.local.PreferencesManager
import com.vaskorr.testapp.domain.repository.DataRepository
import com.vaskorr.testapp.domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {
    single { PreferencesManager(get()) }
    single { JsonDataProvider(get()) }
    single<UserRepository> { UserRepositoryImpl(get()) }
    single<DataRepository> { DataRepositoryImpl(get(), get()) }
}