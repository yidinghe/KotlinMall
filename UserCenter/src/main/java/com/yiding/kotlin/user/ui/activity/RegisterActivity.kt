package com.yiding.kotlin.user.ui.activity

import android.os.Bundle
import android.view.View
import com.yiding.kotlin.base.common.AppManager
import com.yiding.kotlin.base.ext.enable
import com.yiding.kotlin.base.ext.onClick
import com.yiding.kotlin.base.ui.activity.BaseMvpActivity
import com.yiding.kotlin.user.R
import com.yiding.kotlin.user.injection.component.DaggerUserComponent
import com.yiding.kotlin.user.injection.module.UserModule
import com.yiding.kotlin.user.presenter.RegisterPresenter
import com.yiding.kotlin.user.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

class RegisterActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView, View.OnClickListener {

    private var pressTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        initView()
    }

    private fun initView() {
        mRegisterBtn.enable(mMobileEt) { isBtnEnable() }
        mRegisterBtn.enable(mVerifyCodeEt) { isBtnEnable() }
        mRegisterBtn.enable(mPwdEt) { isBtnEnable() }
        mRegisterBtn.enable(mPwdConfirmEt) { isBtnEnable() }

        mVerifyCodeBtn.setOnClickListener(this)
        mRegisterBtn.setOnClickListener(this)
    }

    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(mActivityComponent)
            .userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }

    override fun onRegisterResult(result: String) {
        toast(result)
    }

    override fun onBackPressed() {
        val time = System.currentTimeMillis()
        if (time - pressTime > 2000) {
            toast("再按一次退出程序")
            pressTime = time
        } else {
            AppManager.instance.exitApp(this)
        }
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.mVerifyCodeBtn -> {
                mVerifyCodeBtn.requestSendVerifyNumber()
                toast("发送验证码成功")
            }

            R.id.mRegisterBtn -> {
                mPresenter.register(
                    mMobileEt.text.toString(),
                    mVerifyCodeEt.text.toString(),
                    mPwdEt.text.toString()
                )
            }
        }
    }

    private fun isBtnEnable(): Boolean {
        return mMobileEt.text.isNullOrEmpty().not() &&
                mVerifyCodeEt.text.isNullOrEmpty().not() &&
                mPwdEt.text.isNullOrEmpty().not() &&
                mPwdConfirmEt.text.isNullOrEmpty().not()
    }
}
