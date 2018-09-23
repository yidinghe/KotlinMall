package com.yiding.kotlin.user.presenter

import com.yiding.kotlin.base.ext.execute
import com.yiding.kotlin.base.presenter.BasePresenter
import com.yiding.kotlin.base.rx.BaseSubscriber
import com.yiding.kotlin.user.data.protocol.UserInfo
import com.yiding.kotlin.user.presenter.view.LoginView
import com.yiding.kotlin.user.presenter.view.RegisterView
import com.yiding.kotlin.user.service.UserService
import javax.inject.Inject

class LoginPresenter @Inject constructor() : BasePresenter<LoginView>() {

    @Inject
    lateinit var userService: UserService

    fun login(mobile: String, pwd: String, pushId: String) {

        if (!checkNetWork()) {
            return
        }

        mView.showLoading()

        userService.login(mobile, pwd, pushId)
            .execute(object : BaseSubscriber<UserInfo>(mView) {
                override fun onNext(t: UserInfo) {
                    mView.onLoginResult(t)
                }
            }, lifecycleProvider)

    }
}