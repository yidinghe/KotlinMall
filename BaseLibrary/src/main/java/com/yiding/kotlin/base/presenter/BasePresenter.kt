package com.yiding.kotlin.base.presenter

import com.trello.rxlifecycle.LifecycleProvider
import com.yiding.kotlin.base.presenter.view.BaseView
import javax.inject.Inject

open class BasePresenter<T : BaseView> {
    lateinit var mView: T

    @Inject
    lateinit var lifecycleProvider: LifecycleProvider<*>
}