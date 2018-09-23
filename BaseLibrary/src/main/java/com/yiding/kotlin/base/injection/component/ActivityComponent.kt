package com.yiding.kotlin.base.injection.component

import android.app.Activity
import android.content.Context
import com.trello.rxlifecycle.LifecycleProvider
import com.yiding.kotlin.base.injection.ActivityScope
import com.yiding.kotlin.base.injection.module.ActivityModule
import com.yiding.kotlin.base.injection.module.LifeCycleProviderModule
import dagger.Component

@ActivityScope
@Component(
    dependencies = [AppComponent::class],
    modules = [ActivityModule::class, LifeCycleProviderModule::class]
)
interface ActivityComponent {
    fun activity(): Activity
    fun context(): Context
    fun lifecycleProvider(): LifecycleProvider<*>
}