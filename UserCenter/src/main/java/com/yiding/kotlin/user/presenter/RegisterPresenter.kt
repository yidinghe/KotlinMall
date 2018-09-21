package com.yiding.kotlin.user.presenter

import com.yiding.kotlin.base.ext.execute
import com.yiding.kotlin.base.presenter.BasePresenter
import com.yiding.kotlin.base.rx.BaseSubscriber
import com.yiding.kotlin.user.presenter.view.RegisterView
import com.yiding.kotlin.user.service.UserService
import javax.inject.Inject

class RegisterPresenter @Inject constructor() : BasePresenter<RegisterView>() {

    @Inject
    lateinit var userService: UserService

    fun register(mobile: String, verifyCode: String, pwd: String) {

        userService.register(mobile, pwd, verifyCode)
                .execute(object : BaseSubscriber<Boolean>() {
                    override fun onNext(t: Boolean) {
                        mView.onRegisterResult(t)
                    }
                })

    }
}