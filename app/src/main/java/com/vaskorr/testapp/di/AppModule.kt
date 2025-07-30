package com.vaskorr.testapp.di

import com.vaskorr.testapp.data.di.dataModule
import com.vaskorr.testapp.domain.di.domainModule
import com.vaskorr.testapp.presentation.di.presentationModule
import org.koin.dsl.module

val appModule = module {
    includes(
        dataModule,
        domainModule,
        presentationModule
    )
}