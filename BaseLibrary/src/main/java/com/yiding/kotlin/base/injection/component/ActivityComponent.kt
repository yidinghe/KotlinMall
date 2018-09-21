package com.yiding.kotlin.base.injection.component

import android.app.Activity
import android.content.Context
import com.yiding.kotlin.base.injection.ActivityScope
import com.yiding.kotlin.base.injection.module.ActivityModule
import dagger.Component

@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {
    fun activity(): Activity
}