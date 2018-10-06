package com.yiding.kotlin.goods.injection.module

import com.yiding.kotlin.goods.service.CategoryService
import com.yiding.kotlin.goods.service.impl.CategoryServiceImpl
import dagger.Module
import dagger.Provides

@Module
class CategoryModule {

    @Provides
    fun providesCategoryService(service: CategoryServiceImpl): CategoryService {
        return service
    }

}