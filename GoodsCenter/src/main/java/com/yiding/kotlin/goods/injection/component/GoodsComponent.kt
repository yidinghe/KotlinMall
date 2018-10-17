package com.yiding.kotlin.goods.injection.component

import com.yiding.kotlin.base.injection.PerComponentScope
import com.yiding.kotlin.base.injection.component.ActivityComponent
import com.yiding.kotlin.goods.injection.module.CategoryModule
import com.yiding.kotlin.goods.injection.module.GoodsModule
import com.yiding.kotlin.goods.ui.activity.GoodsActivity
import com.yiding.kotlin.goods.ui.fragment.CategoryFragment
import dagger.Component

@PerComponentScope
@Component(
    dependencies = [ActivityComponent::class],
    modules = [GoodsModule::class]
)
interface GoodsComponent {

    fun inject(activity: GoodsActivity)
}