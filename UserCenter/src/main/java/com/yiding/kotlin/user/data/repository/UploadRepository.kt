package com.yiding.kotlin.user.data.repository

import com.yiding.kotlin.base.data.net.RetrofitFactory
import com.yiding.kotlin.base.data.protocol.BaseResp
import com.yiding.kotlin.user.data.api.UploadApi
import rx.Observable
import javax.inject.Inject

class UploadRepository @Inject constructor() {

    fun getUploadToken(): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(UploadApi::class.java)
            .getUploadToken()
    }

}