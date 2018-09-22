package com.yiding.kotlin.base.ui.fragment

import android.os.Bundle
import com.yiding.kotlin.base.common.BaseApplication
import com.yiding.kotlin.base.injection.component.ActivityComponent
import com.yiding.kotlin.base.injection.component.DaggerActivityComponent
import com.yiding.kotlin.base.injection.module.ActivityModule
import com.yiding.kotlin.base.injection.module.LifeCycleProviderModule
import com.yiding.kotlin.base.presenter.BasePresenter
import com.yiding.kotlin.base.presenter.view.BaseView
import org.jetbrains.anko.support.v4.toast
import javax.inject.Inject

abstract class BaseMvpFragment<T : BasePresenter<*>> : BaseFragment(), BaseView {

    @Inject
    lateinit var mPresenter: T
    private lateinit var mActivityComponent: ActivityComponent

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

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun onError(text: String) {
        toast(text)
    }

}