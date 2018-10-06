package com.yiding.kotlin.goods.data.api

import com.yiding.kotlin.base.data.protocol.BaseResp
import com.yiding.kotlin.goods.data.protocol.Category
import com.yiding.kotlin.goods.data.protocol.GetCategoryReq
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

/*
    商品分类接口
 */
interface CategoryApi {
    /*
        获取商品分类列表
     */
    @POST("category/getCategory")
    fun getCategory(@Body req: GetCategoryReq): Observable<BaseResp<MutableList<Category>?>>
}
