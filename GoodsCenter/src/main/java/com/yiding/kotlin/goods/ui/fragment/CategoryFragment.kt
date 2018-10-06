package com.yiding.kotlin.goods.ui.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yiding.kotlin.base.ui.fragment.BaseMvpFragment
import com.yiding.kotlin.goods.R
import com.yiding.kotlin.goods.data.protocol.Category
import com.yiding.kotlin.goods.injection.component.DaggerCategoryComponent
import com.yiding.kotlin.goods.injection.module.CategoryModule
import com.yiding.kotlin.goods.presenter.CategoryPresenter
import com.yiding.kotlin.goods.presenter.view.CategoryView
import kotlinx.android.synthetic.main.fragment_category.*

class CategoryFragment : BaseMvpFragment<CategoryPresenter>(), CategoryView {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_category, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        mTopCategoryRv.layoutManager = LinearLayoutManager(context)

    }

    override fun injectComponent() {
        DaggerCategoryComponent.builder().activityComponent(mActivityComponent).categoryModule(
            CategoryModule()
        ).build().inject(this)
        mPresenter.mView = this
    }

    override fun onGetCategoryResult(result: MutableList<Category>?) {

    }
}