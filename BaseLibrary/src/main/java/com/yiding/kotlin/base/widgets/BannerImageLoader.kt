package com.yiding.kotlin.base.widgets

import android.content.Context
import android.widget.ImageView
import com.yiding.kotlin.base.utils.GlideUtils
import com.youth.banner.loader.ImageLoader

class BannerImageLoader : ImageLoader() {
    override fun displayImage(context: Context, path: Any, imageView: ImageView) {
        GlideUtils.loadImageFitCenter(context, path.toString(), imageView)
    }
}