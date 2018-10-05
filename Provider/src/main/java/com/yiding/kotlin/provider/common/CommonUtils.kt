package com.yiding.kotlin.provider.common

import com.yiding.kotlin.base.common.BaseConstant
import com.yiding.kotlin.base.utils.AppPrefsUtils

fun isLogined(): Boolean {
    return AppPrefsUtils.getString(BaseConstant.KEY_SP_TOKEN).isNotEmpty()
}