package com.yiding.kotlin.base.presenter

import com.yiding.kotlin.base.presenter.view.BaseView

open class BasePresenter<T : BaseView> {
    lateinit var mView: T
}