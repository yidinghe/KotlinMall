package com.yiding.kotlin.base.ui.fragment

import android.os.Bundle
import com.yiding.kotlin.base.common.BaseApplication
import com.yiding.kotlin.base.injection.component.ActivityComponent
import com.yiding.kotlin.base.injection.component.DaggerActivityComponent
import com.yiding.kotlin.base.injection.module.ActivityModule
import com.yiding.kotlin.base.injection.module.LifeCycleProviderModule
import com.yiding.kotlin.base.presenter.BasePresenter
import com.yiding.kotlin.base.presenter.view.BaseView
import javax.inject.Inject

abstract class BaseMvpFragment<T : BasePresenter<*>> : BaseFragment(), BaseView {

    @Inject
    lateinit var mPresenter: T
    lateinit var mActivityComponent: ActivityComponent

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityInjection()
        injectComponent()
    }

    abstract fun injectComponent()

    private fun initActivityInjection() {
        mActivityComponent = DaggerActivityComponent.builder()
                .appComponent((requireActivity().application as BaseApplication).appComponent)
                .activityModule(ActivityModule(requireActivity()))
                .lifeCycleProviderModule(LifeCycleProviderModule(this))
                .build()
    }
}