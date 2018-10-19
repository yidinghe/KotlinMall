package com.yiding.kotlin.goods.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.kennyc.view.MultiStateView
import com.yiding.kotlin.base.ext.startLoading
import com.yiding.kotlin.base.ui.activity.BaseMvpActivity
import com.yiding.kotlin.goods.R
import com.yiding.kotlin.goods.common.GoodsConstant
import com.yiding.kotlin.goods.data.protocol.Goods
import com.yiding.kotlin.goods.injection.component.DaggerGoodsComponent
import com.yiding.kotlin.goods.injection.module.GoodsModule
import com.yiding.kotlin.goods.presenter.GoodsListPresenter
import com.yiding.kotlin.goods.presenter.view.GoodsListView
import com.yiding.kotlin.goods.ui.adapter.GoodsAdapter
import kotlinx.android.synthetic.main.activity_goods.*

class GoodsActivity : BaseMvpActivity<GoodsListPresenter>(), GoodsListView {

    private lateinit var mGoodsAdapter: GoodsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_goods)
        initView()
        loadData()
    }

    private fun initView() {
        mGoodsRv.layoutManager = GridLayoutManager(this, 2)
        mGoodsAdapter = GoodsAdapter(this)
        mGoodsRv.adapter = mGoodsAdapter
    }

    private fun loadData() {
        mMultiStateView.startLoading()
        mPresenter.getGoodsList(intent.getIntExtra(GoodsConstant.KEY_CATEGORY_ID, 1), 1)
    }

    override fun injectComponent() {
        DaggerGoodsComponent.builder().activityComponent(mActivityComponent)
            .goodsModule(GoodsModule()).build().inject(this)
        mPresenter.mView = this
    }

    override fun onGetGoodsListResult(result: MutableList<Goods>?) {
        if (result != null && result.size > 0) {
            mGoodsAdapter.setData(result)
            mMultiStateView.viewState = MultiStateView.VIEW_STATE_CONTENT
        } else {
            mMultiStateView.viewState = MultiStateView.VIEW_STATE_EMPTY
        }
    }
}