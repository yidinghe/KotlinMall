package com.yiding.kotlin.goods.injection.module

import com.yiding.kotlin.goods.service.GoodsService
import com.yiding.kotlin.goods.service.impl.GoodsServiceImpl
import dagger.Module
import dagger.Provides

@Module
class GoodsModule {

    @Provides
    fun provideGoodservice(goodsService: GoodsServiceImpl): GoodsService {
        return goodsService
    }

}