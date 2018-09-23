package com.yiding.kotlin.user.data.repository

import com.yiding.kotlin.base.data.net.RetrofitFactory
import com.yiding.kotlin.base.data.protocol.BaseResp
import com.yiding.kotlin.user.data.api.UserApi
import com.yiding.kotlin.user.data.protocol.LoginReq
import com.yiding.kotlin.user.data.protocol.RegisterReq
import com.yiding.kotlin.user.data.protocol.UserInfo
import rx.Observable
import javax.inject.Inject

class UserRepository @Inject constructor() {

    fun register(mobile: String, pwd: String, verifyCode: String): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(UserApi::class.java)
                .register(RegisterReq(mobile, verifyCode, pwd))
    }

    fun login(mobile: String, pwd: String, pushId: String): Observable<BaseResp<UserInfo>> {
        return RetrofitFactory.instance.create(UserApi::class.java)
                .login(LoginReq(mobile, pwd, pushId))
    }
}