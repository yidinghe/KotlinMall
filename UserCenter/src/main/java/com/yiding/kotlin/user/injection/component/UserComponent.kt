package com.yiding.kotlin.user.injection.component

import com.yiding.kotlin.user.injection.module.UserModule
import com.yiding.kotlin.user.ui.activity.RegisterActivity
import dagger.Component

@Component(modules = [UserModule::class])
interface UserComponent {

    fun inject(activity: RegisterActivity)
}