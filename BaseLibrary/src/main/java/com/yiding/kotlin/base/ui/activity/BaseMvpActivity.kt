package com.yiding.kotlin.base.ui.activity

import android.os.Bundle
import com.yiding.kotlin.base.common.BaseApplication
import com.yiding.kotlin.base.injection.component.ActivityComponent
import com.yiding.kotlin.base.injection.component.DaggerActivityComponent
import com.yiding.kotlin.base.injection.module.ActivityModule
import com.yiding.kotlin.base.injection.module.LifeCycleProviderModule
import com.yiding.kotlin.base.presenter.BasePresenter
import com.yiding.kotlin.base.presenter.view.BaseView
import javax.inject.Inject

abstract class BaseMvpActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {

    @Inject
    lateinit var mPresenter: T
    lateinit var mActivityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityInjection()
        injectComponent()
    }

    abstract fun injectComponent()

    private fun initActivityInjection() {
        mActivityComponent = DaggerActivityComponent.builder()
                .appComponent((application as BaseApplication).appComponent)
                .activityModule(ActivityModule(this))
                .lifeCycleProviderModule(LifeCycleProviderModule(this))
                .build()
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun onError() {
    }
}