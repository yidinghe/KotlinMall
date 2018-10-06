package com.yiding.kotlin.goods.presenter.view

import com.yiding.kotlin.base.presenter.view.BaseView
import com.yiding.kotlin.goods.data.protocol.Category

interface CategoryView : BaseView {

    fun onGetCategoryResult(result: MutableList<Category>?)
}