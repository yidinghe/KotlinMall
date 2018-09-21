package com.yiding.kotlin.base.common

import android.app.Application
import com.yiding.kotlin.base.injection.component.AppComponent
import com.yiding.kotlin.base.injection.component.DaggerAppComponent
import com.yiding.kotlin.base.injection.module.AppModule

class BaseApplication : Application() {

    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        initAppInjection()
    }

    private fun initAppInjection() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}