package com.yiding.kotlin.user.service.impl

import com.yiding.kotlin.base.ext.convert
import com.yiding.kotlin.base.ext.convertBoolean
import com.yiding.kotlin.base.rx.BaseException
import com.yiding.kotlin.base.rx.BaseFuncBoolean
import com.yiding.kotlin.user.data.protocol.UserInfo
import com.yiding.kotlin.user.data.repository.UserRepository
import com.yiding.kotlin.user.service.UserService
import rx.Observable
import javax.inject.Inject

class UserServiceImpl @Inject constructor() : UserService {


    @Inject
    lateinit var repository: UserRepository

    override fun register(mobile: String, pwd: String, verifyCode: String): Observable<Boolean> {

        return repository
            .register(mobile, pwd, verifyCode)
            .convertBoolean()
    }

    override fun login(mobile: String, pwd: String, pushId: String): Observable<UserInfo> {
        return repository
            .login(mobile, pwd, pushId)
            .convert()
    }
}