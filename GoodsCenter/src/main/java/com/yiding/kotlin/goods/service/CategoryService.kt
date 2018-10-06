package com.yiding.kotlin.goods.service

import com.yiding.kotlin.goods.data.protocol.Category
import rx.Observable

interface CategoryService {
    fun getCategory(parentId: Int): Observable<MutableList<Category>?>
}