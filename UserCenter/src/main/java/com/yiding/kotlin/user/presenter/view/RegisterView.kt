package com.yiding.kotlin.user.presenter.view

import com.yiding.kotlin.base.presenter.view.BaseView

interface RegisterView : BaseView {

    fun onRegisterResult(result: Boolean)
}