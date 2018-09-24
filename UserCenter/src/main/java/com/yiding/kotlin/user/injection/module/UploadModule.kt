package com.yiding.kotlin.user.injection.module

import com.yiding.kotlin.user.service.UploadService
import com.yiding.kotlin.user.service.impl.UploadServiceImpl
import dagger.Module
import dagger.Provides

@Module
class UploadModule {

    @Provides
    fun providesUploadService(service: UploadServiceImpl): UploadService {
        return service
    }

}