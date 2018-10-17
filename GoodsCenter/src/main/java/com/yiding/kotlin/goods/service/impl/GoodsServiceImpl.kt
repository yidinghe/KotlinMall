package com.yiding.kotlin.goods.service.impl

import com.yiding.kotlin.base.ext.convert
import com.yiding.kotlin.goods.data.protocol.Goods
import com.yiding.kotlin.goods.data.repository.GoodsRepository
import com.yiding.kotlin.goods.service.GoodsService
import rx.Observable
import javax.inject.Inject

/*
    商品 业务层 实现类
 */
class GoodsServiceImpl @Inject constructor() : GoodsService {

    @Inject
    lateinit var repository: GoodsRepository

    /*
        获取商品列表
     */
    override fun getGoodsList(categoryId: Int, pageNo: Int): Observable<MutableList<Goods>?> {
        return repository.getGoodsList(categoryId, pageNo).convert()
    }

    /*
        根据关键字查询商品
     */
    override fun getGoodsListByKeyword(
        keyword: String,
        pageNo: Int
    ): Observable<MutableList<Goods>?> {
        return repository.getGoodsListByKeyword(keyword, pageNo).convert()
    }

    /*
        获取商品详情
     */
    override fun getGoodsDetail(goodsId: Int): Observable<Goods> {
        return repository.getGoodsDetail(goodsId).convert()
    }
}
