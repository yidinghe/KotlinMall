package com.yiding.kotlin.base.ui.activity

import android.os.Bundle
import android.os.PersistableBundle
import com.yiding.kotlin.base.common.BaseApplication
import com.yiding.kotlin.base.injection.component.ActivityComponent
import com.yiding.kotlin.base.injection.component.DaggerActivityComponent
import com.yiding.kotlin.base.injection.module.ActivityModule
import com.yiding.kotlin.base.presenter.BasePresenter
import com.yiding.kotlin.base.presenter.view.BaseView
import javax.inject.Inject

open class BaseMvpActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {

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


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        initActivityInjection()
    }

    private fun initActivityInjection() {
        mActivityComponent = DaggerActivityComponent.builder()
                .appComponent((application as BaseApplication).appComponent)
                .activityModule(ActivityModule(this)).build()
    }
}