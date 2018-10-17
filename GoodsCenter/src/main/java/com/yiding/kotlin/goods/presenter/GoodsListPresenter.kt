package com.yiding.kotlin.goods.presenter

import com.yiding.kotlin.base.ext.execute
import com.yiding.kotlin.base.presenter.BasePresenter
import com.yiding.kotlin.base.rx.BaseSubscriber
import com.yiding.kotlin.goods.data.protocol.Category
import com.yiding.kotlin.goods.presenter.view.CategoryView
import com.yiding.kotlin.goods.service.CategoryService
import javax.inject.Inject

class GoodsListPresenter @Inject constructor() : BasePresenter<CategoryView>() {

    @Inject
    lateinit var categoryService: CategoryService

    fun getCategory(parentId: Int) {

        if (!checkNetWork()) {
            return
        }

        mView.showLoading()

        categoryService.getCategory(parentId)
            .execute(object : BaseSubscriber<MutableList<Category>?>(mView) {
                override fun onNext(t: MutableList<Category>?) {
                    mView.onGetCategoryResult(t)
                }
            }, lifecycleProvider)

    }
}