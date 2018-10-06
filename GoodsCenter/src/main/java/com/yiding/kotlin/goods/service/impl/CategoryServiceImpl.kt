package com.yiding.kotlin.goods.service.impl

import com.yiding.kotlin.base.ext.convert
import com.yiding.kotlin.goods.data.protocol.Category
import com.yiding.kotlin.goods.data.repository.CategoryRepository
import com.yiding.kotlin.goods.service.CategoryService
import rx.Observable
import javax.inject.Inject

class CategoryServiceImpl @Inject constructor() : CategoryService {

    @Inject
    lateinit var repository: CategoryRepository

    override fun getCategory(parentId: Int): Observable<MutableList<Category>?> {
        return repository.getCategory(parentId).convert()
    }

}