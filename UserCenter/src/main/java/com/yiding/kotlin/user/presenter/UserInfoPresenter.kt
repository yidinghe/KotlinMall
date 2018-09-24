package com.yiding.kotlin.user.presenter

import com.yiding.kotlin.base.ext.execute
import com.yiding.kotlin.base.presenter.BasePresenter
import com.yiding.kotlin.base.rx.BaseSubscriber
import com.yiding.kotlin.user.presenter.view.UserInfoView
import com.yiding.kotlin.user.service.UploadService
import com.yiding.kotlin.user.service.UserService
import javax.inject.Inject

class UserInfoPresenter @Inject constructor() : BasePresenter<UserInfoView>() {

    @Inject
    lateinit var userService: UserService

    @Inject
    lateinit var uploadService: UploadService

    fun getUploadToken() {
        if (!checkNetWork()) {
            return
        }

        mView.showLoading()

        uploadService.getUploadToken()
            .execute(object : BaseSubscriber<String>(mView) {
                override fun onNext(t: String) {
                    mView.onGetUploadTokenResult(t)
                }
            }, lifecycleProvider)
    }
}