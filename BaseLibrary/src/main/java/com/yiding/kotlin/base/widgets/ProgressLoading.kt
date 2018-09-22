package com.yiding.kotlin.base.widgets

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.AnimationDrawable
import android.view.Gravity
import android.widget.ImageView
import com.yiding.kotlin.base.R
import org.jetbrains.anko.find

class ProgressLoading(context: Context, theme: Int) : Dialog(context, theme) {

    companion object {
        private lateinit var mDialog: ProgressLoading
        private var animDrawable: AnimationDrawable? = null

        fun create(context: Context) {
            mDialog = ProgressLoading(context, R.style.LightProgressDialog)
            mDialog.setContentView(R.layout.progress_dialog)
            mDialog.setCancelable(true)
            mDialog.setCanceledOnTouchOutside(false)
            mDialog.window?.attributes?.gravity = Gravity.CENTER

            val layoutParams = mDialog.window?.attributes
            layoutParams?.dimAmount = 0.2f
            mDialog.window?.attributes = layoutParams

            val loadingView = mDialog.find<ImageView>(R.id.iv_loading)
            animDrawable = loadingView.background as AnimationDrawable
        }
    }

    fun showLoading() {
        super.show()
        animDrawable?.start()
    }

    fun hideLoading() {
        super.dismiss()
        animDrawable?.stop()
    }
}
