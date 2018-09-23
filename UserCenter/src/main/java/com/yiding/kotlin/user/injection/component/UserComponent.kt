package com.yiding.kotlin.user.injection.component

import com.yiding.kotlin.base.injection.PerComponentScope
import com.yiding.kotlin.base.injection.component.ActivityComponent
import com.yiding.kotlin.user.injection.module.UserModule
import com.yiding.kotlin.user.ui.activity.ForgetPwdActivity
import com.yiding.kotlin.user.ui.activity.LoginActivity
import com.yiding.kotlin.user.ui.activity.RegisterActivity
import com.yiding.kotlin.user.ui.activity.ResetPwdActivity
import dagger.Component

@PerComponentScope
@Component(dependencies = [ActivityComponent::class], modules = [UserModule::class])
interface UserComponent {

    fun inject(activity: RegisterActivity)
    fun inject(activity: LoginActivity)
    fun inject(activity: ForgetPwdActivity)
    fun inject(activity: ResetPwdActivity)
}