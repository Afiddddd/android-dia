package com.example.tugasandroid.data.di

import com.example.tugasandroid.viewmodel.JobViewModel
import com.example.tugasandroid.viewmodel.LoginViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [HomeModule::class])
interface HomeComponent {
    fun injectLogin(loginViewModel: LoginViewModel)
    fun injectJob(jobViewModel: JobViewModel)
}
