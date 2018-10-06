package com.yiding.kotlin.goods.data.repository

import com.yiding.kotlin.base.data.net.RetrofitFactory
import com.yiding.kotlin.base.data.protocol.BaseResp
import com.yiding.kotlin.goods.data.api.CategoryApi
import com.yiding.kotlin.goods.data.protocol.Category
import com.yiding.kotlin.goods.data.protocol.GetCategoryReq
import rx.Observable
import javax.inject.Inject

class CategoryRepository @Inject constructor() {

    fun getCategory(parentId: Int): Observable<BaseResp<MutableList<Category>?>> {
        return RetrofitFactory.instance.create(CategoryApi::class.java)
            .getCategory(GetCategoryReq(parentId))
    }
}