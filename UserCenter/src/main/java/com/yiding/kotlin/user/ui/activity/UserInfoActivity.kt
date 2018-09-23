package com.yiding.kotlin.user.ui.activity

import android.os.Bundle
import android.view.View
import com.bigkoo.alertview.AlertView
import com.bigkoo.alertview.OnItemClickListener
import com.yiding.kotlin.base.ext.onClick
import com.yiding.kotlin.base.ui.activity.BaseMvpActivity
import com.yiding.kotlin.user.R
import com.yiding.kotlin.user.injection.component.DaggerUserComponent
import com.yiding.kotlin.user.injection.module.UserModule
import com.yiding.kotlin.user.presenter.UserInfoPresenter
import com.yiding.kotlin.user.presenter.view.UserInfoView
import kotlinx.android.synthetic.main.activity_user_info.*
import org.jetbrains.anko.toast

class UserInfoActivity : BaseMvpActivity<UserInfoPresenter>(), UserInfoView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)

        initView()
    }

    private fun initView() {
        mUserIconView.onClick {
            showAlertView()
        }
    }

    private fun showAlertView() {
        AlertView(
            "选择图片",
            "",
            "取消",
            null,
            arrayOf("拍照", "相册"),
            this,
            AlertView.Style.ActionSheet,
            OnItemClickListener { o, position ->
                when (position) {
                    0 -> toast("拍照")
                    1 -> toast("相册")
                }
            }).show()
    }

    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(mActivityComponent)
            .userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }

}
