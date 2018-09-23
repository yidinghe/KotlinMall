package com.yiding.kotlin.user.presenter

import com.yiding.kotlin.base.ext.execute
import com.yiding.kotlin.base.presenter.BasePresenter
import com.yiding.kotlin.base.rx.BaseSubscriber
import com.yiding.kotlin.user.data.protocol.UserInfo
import com.yiding.kotlin.user.presenter.view.ForgetPwdView
import com.yiding.kotlin.user.presenter.view.LoginView
import com.yiding.kotlin.user.presenter.view.RegisterView
import com.yiding.kotlin.user.service.UserService
import javax.inject.Inject

class ForgetPwdPresenter @Inject constructor() : BasePresenter<ForgetPwdView>() {

    @Inject
    lateinit var userService: UserService

    fun forgetPwd(mobile: String, verifyCode: String) {

        if (!checkNetWork()) {
            return
        }

        mView.showLoading()

        userService.forgetPwd(mobile, verifyCode)
            .execute(object : BaseSubscriber<Boolean>(mView) {
                override fun onNext(t: Boolean) {
                    if (t)
                        mView.onForgetPwdResult("验证成功")
                }
            }, lifecycleProvider)

    }
}