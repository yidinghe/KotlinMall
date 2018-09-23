package com.yiding.kotlin.user.ui.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import com.bigkoo.alertview.AlertView
import com.bigkoo.alertview.OnItemClickListener
import com.jph.takephoto.app.TakePhoto
import com.jph.takephoto.app.TakePhotoImpl
import com.jph.takephoto.compress.CompressConfig
import com.jph.takephoto.model.InvokeParam
import com.jph.takephoto.model.TContextWrap
import com.jph.takephoto.model.TResult
import com.jph.takephoto.permission.InvokeListener
import com.jph.takephoto.permission.PermissionManager
import com.jph.takephoto.permission.TakePhotoInvocationHandler
import com.yiding.kotlin.base.ext.onClick
import com.yiding.kotlin.base.ui.activity.BaseMvpActivity
import com.yiding.kotlin.base.utils.DateUtils
import com.yiding.kotlin.user.R
import com.yiding.kotlin.user.injection.component.DaggerUserComponent
import com.yiding.kotlin.user.injection.module.UserModule
import com.yiding.kotlin.user.presenter.UserInfoPresenter
import com.yiding.kotlin.user.presenter.view.UserInfoView
import kotlinx.android.synthetic.main.activity_user_info.*
import org.jetbrains.anko.toast
import java.io.File

class UserInfoActivity : BaseMvpActivity<UserInfoPresenter>(), UserInfoView,
    TakePhoto.TakeResultListener, InvokeListener {


    private lateinit var mTakePhoto: TakePhoto
    private lateinit var mTempFile: File
    private lateinit var mInvokeParam: InvokeParam

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)

        mTakePhoto =
                TakePhotoInvocationHandler.of(this).bind(TakePhotoImpl(this, this)) as TakePhoto
        initView()
        mTakePhoto.onCreate(savedInstanceState)
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
                mTakePhoto.onEnableCompress(CompressConfig.ofDefaultConfig(), false)
                when (position) {
                    0 -> {
                        createTempFile()
                        mTakePhoto.onPickFromCapture(Uri.fromFile(mTempFile))
                    }
                    1 -> mTakePhoto.onPickFromGallery()
                }
            }).show()
    }

    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(mActivityComponent)
            .userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }

    override fun takeSuccess(result: TResult?) {
        Log.d("takePhoto", result?.image?.originalPath)
        Log.d("takePhoto", result?.image?.compressPath)
    }

    override fun takeCancel() {
    }

    override fun takeFail(result: TResult?, msg: String?) {
        Log.e("takePhoto", msg)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        mTakePhoto.onActivityResult(requestCode, resultCode, data)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        val permissionType =
            PermissionManager.onRequestPermissionsResult(requestCode, permissions, grantResults)
        PermissionManager.handlePermissionsResult(this, permissionType, mInvokeParam, this)
    }

    override fun invoke(invokeParam: InvokeParam): PermissionManager.TPermissionType {
        val permissionType =
            PermissionManager.checkPermission(TContextWrap.of(this), invokeParam.method)
        if (PermissionManager.TPermissionType.WAIT == permissionType) {
            mInvokeParam = invokeParam
        }
        return permissionType
    }

    fun createTempFile() {
        val tempFileName = "${DateUtils.curTime}.png"
        if (Environment.MEDIA_MOUNTED == Environment.getExternalStorageState()) {
            mTempFile = File(Environment.getExternalStorageDirectory(), tempFileName)
            return
        }
        mTempFile = File(filesDir, tempFileName)
    }
}
