package com.yiding.kotlin.user.service.impl

import com.yiding.kotlin.base.ext.convert
import com.yiding.kotlin.user.data.repository.UploadRepository
import com.yiding.kotlin.user.service.UploadService
import rx.Observable
import javax.inject.Inject

class UploadServiceImpl @Inject constructor() : UploadService {

    @Inject
    lateinit var repository: UploadRepository

    override fun getUploadToken(): Observable<String> {
        return repository.getUploadToken().convert()
    }

}