package com.yiding.kotlin.user.service.impl

import com.yiding.kotlin.user.service.UserService
import rx.Observable

class UserSeriviceImpl : UserService {
    override fun register(mobile: String, verifyCode: String, pwd: String): Observable<Boolean> {
        return Observable.just(true)
    }
}