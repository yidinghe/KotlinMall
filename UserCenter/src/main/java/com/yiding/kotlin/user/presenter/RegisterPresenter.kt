package com.yiding.kotlin.user.presenter

import com.yiding.kotlin.base.presenter.BasePresenter
import com.yiding.kotlin.user.presenter.view.RegisterView

class RegisterPresenter : BasePresenter<RegisterView>() {

    fun register() {
        mView.onRegisterResult(true)
    }
}