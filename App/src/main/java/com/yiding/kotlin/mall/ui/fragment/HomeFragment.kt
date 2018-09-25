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

    private lateinit var mHomeBanner: Banner

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val rootView = inflater.inflate(R.layout.fragment_home, null)
        mHomeBanner = rootView.findViewById(R.id.mHomeBanner)
        initBanner()

        return rootView
    }

    private fun initBanner() {
        mHomeBanner.setImageLoader(BannerImageLoader())
        mHomeBanner.setImages(
            listOf(
                HOME_BANNER_ONE,
                HOME_BANNER_TWO,
                HOME_BANNER_THREE,
                HOME_BANNER_FOUR,
                HOME_BANNER_FIVE
            )
        )
        mHomeBanner.setBannerAnimation(Transformer.Accordion)
        mHomeBanner.setDelayTime(2000)
        mHomeBanner.setIndicatorGravity(BannerConfig.RIGHT)
        mHomeBanner.start()
    }
}