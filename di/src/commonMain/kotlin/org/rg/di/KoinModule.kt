package org.rg.di

import CustomerRepositoryImpl
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.rg.auth.AuthViewModel
import org.rg.data.domain.CustomerRepository
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val sharedModule =
    module {
        single<CustomerRepository> { CustomerRepositoryImpl() }
        viewModelOf(::AuthViewModel)
    }

fun initializeKoin(config : (KoinApplication.() -> Unit))
{
    startKoin {
        config?.invoke(this)
        modules(sharedModule)
    }

}