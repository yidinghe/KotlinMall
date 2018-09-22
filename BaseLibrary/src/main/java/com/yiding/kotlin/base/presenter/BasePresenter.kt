package com.yiding.kotlin.base.presenter

import android.content.Context
import com.trello.rxlifecycle.LifecycleProvider
import com.yiding.kotlin.base.presenter.view.BaseView
import com.yiding.kotlin.base.utils.NetWorkUtils
import javax.inject.Inject

open class BasePresenter<T : BaseView> {
    lateinit var mView: T

    @Inject
    lateinit var lifecycleProvider: LifecycleProvider<*>

    @Inject
    lateinit var context: Context

    fun checkNetWork(): Boolean {
        if (NetWorkUtils.isNetWorkAvailable(context)) {
            return true
        }
        mView.onError("No Network")
        return false
    }
}