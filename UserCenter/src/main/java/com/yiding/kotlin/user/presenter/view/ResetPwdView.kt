package com.yiding.kotlin.user.presenter.view

import com.yiding.kotlin.base.presenter.view.BaseView
import com.yiding.kotlin.user.data.protocol.UserInfo

interface ResetPwdView : BaseView {

    fun onResetPwdResult(result: String)
}