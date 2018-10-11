package com.yiding.kotlin.goods.ui.fragment

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kennyc.view.MultiStateView
import com.yiding.kotlin.base.ui.adapter.BaseRecyclerViewAdapter
import com.yiding.kotlin.base.ui.fragment.BaseMvpFragment
import com.yiding.kotlin.goods.R
import com.yiding.kotlin.goods.data.protocol.Category
import com.yiding.kotlin.goods.injection.component.DaggerCategoryComponent
import com.yiding.kotlin.goods.injection.module.CategoryModule
import com.yiding.kotlin.goods.presenter.CategoryPresenter
import com.yiding.kotlin.goods.presenter.view.CategoryView
import com.yiding.kotlin.goods.ui.adapter.SecondCategoryAdapter
import com.yiding.kotlin.goods.ui.adapter.TopCategoryAdapter
import kotlinx.android.synthetic.main.fragment_category.*

class CategoryFragment : BaseMvpFragment<CategoryPresenter>(), CategoryView {

    lateinit var topAdapter: TopCategoryAdapter
    lateinit var secondAdapter: SecondCategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        loadData()
    }

    override fun injectComponent() {
        DaggerCategoryComponent.builder().activityComponent(mActivityComponent).categoryModule(
            CategoryModule()
        ).build().inject(this)
        mPresenter.mView = this
    }

    private fun initView() {
        mTopCategoryRv.layoutManager = LinearLayoutManager(context)
        topAdapter = TopCategoryAdapter(requireContext())
        mTopCategoryRv.adapter = topAdapter
        topAdapter.setOnItemClickListener(object :
            BaseRecyclerViewAdapter.OnItemClickListener<Category> {
            override fun onItemClick(item: Category, position: Int) {
                for (category in topAdapter.dataList) {
                    category.isSelected = item.id == category.id
                }
                topAdapter.notifyDataSetChanged()
                mMultiStateView.viewState = MultiStateView.VIEW_STATE_LOADING
                loadData(item.id)
            }
        })

        mSecondCategoryRv.layoutManager = GridLayoutManager(context, 3)
        secondAdapter = SecondCategoryAdapter(requireContext())
        mSecondCategoryRv.adapter = secondAdapter
        secondAdapter.setOnItemClickListener(object :
            BaseRecyclerViewAdapter.OnItemClickListener<Category> {
            override fun onItemClick(item: Category, position: Int) {

            }
        })
    }

    private fun loadData(parentId: Int = 0) {
        mPresenter.getCategory(parentId)
    }

    override fun onGetCategoryResult(result: MutableList<Category>?) {
        result?.let {
            if (it[0].parentId == 0) {
                it[0].isSelected = true
                topAdapter.setData(it)
                loadData(it[0].id)
            } else {
                secondAdapter.setData(it)
                mMultiStateView.viewState = MultiStateView.VIEW_STATE_CONTENT
            }
        }
    }
}