package com.yiding.kotlin.user.data.api

import com.yiding.kotlin.base.data.protocol.BaseResp
import com.yiding.kotlin.user.data.protocol.RegisterReq
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

interface UserApi {
    @POST("userCenter/register")
    fun register(@Body req:RegisterReq):Observable<BaseResp<String>>

}