package com.yiding.kotlin.user.injection.module

import com.yiding.kotlin.user.service.UserService
import com.yiding.kotlin.user.service.impl.UserServiceImpl
import dagger.Module
import dagger.Provides

@Module
class UserModule {

    @Provides
    fun providesUserService(service: UserServiceImpl): UserService {
        return service
    }

}