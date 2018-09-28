package com.yiding.kotlin.mall.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yiding.kotlin.base.ui.fragment.BaseFragment
import com.yiding.kotlin.base.widgets.BannerImageLoader
import com.yiding.kotlin.mall.R
import com.yiding.kotlin.mall.common.*
import com.youth.banner.Banner
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        return inflater.inflate(R.layout.fragment_home, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBanner()
        initNews()
    }

    private fun initBanner() {
        mHomeBanner.setImageLoader(BannerImageLoader())
        mHomeBanner.setImages(
            listOf(
                HOME_BANNER_ONE,
                HOME_BANNER_TWO,
                HOME_BANNER_THREE,
                HOME_BANNER_FOUR
            )
        )
        mHomeBanner.setBannerAnimation(Transformer.Accordion)
        mHomeBanner.setDelayTime(2000)
        mHomeBanner.setIndicatorGravity(BannerConfig.RIGHT)
        mHomeBanner.start()
    }

    private fun initNews() {
        mNewsFlipperView.setData(
            arrayOf(
                "贺唐一家加油加油~",
                "橘子大人最可爱啊最可爱",
                "所有人都喜欢和橘子大人聊天~",
                "橘子大人的魅力已经无法抵挡了!!!"
            )
        )
    }

}