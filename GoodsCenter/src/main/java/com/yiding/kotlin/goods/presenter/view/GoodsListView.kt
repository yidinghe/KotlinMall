package com.yiding.kotlin.goods.presenter.view

import com.yiding.kotlin.base.presenter.view.BaseView
import com.yiding.kotlin.goods.data.protocol.Goods

interface GoodsListView : BaseView {

    fun onGetGoodsListResult(result: MutableList<Goods>?)
}