package com.yiding.kotlin.user.service.impl

import com.yiding.kotlin.base.rx.BaseException
import com.yiding.kotlin.user.data.repository.UserRepository
import com.yiding.kotlin.user.service.UserService
import rx.Observable

class UserServiceImpl : UserService {
    override fun register(mobile: String, pwd: String, verifyCode: String): Observable<Boolean> {
        val repository = UserRepository()

        return repository.register(mobile, pwd, verifyCode).flatMap {
            if(it.status != 0) {
                return@flatMap Observable.error<Boolean>(BaseException(it.status, it.message))
            }
            Observable.just(true)
        }
    }
}