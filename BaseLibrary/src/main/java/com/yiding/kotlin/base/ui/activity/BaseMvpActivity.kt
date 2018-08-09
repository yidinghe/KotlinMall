package com.yiding.kotlin.base.ui.activity

import com.yiding.kotlin.base.presenter.BasePresenter
import com.yiding.kotlin.base.presenter.view.BaseView
import javax.inject.Inject

open class BaseMvpActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {

    @Inject
    lateinit var mPresenter: T

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}