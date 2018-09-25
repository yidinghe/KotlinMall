package com.yiding.kotlin.base.widgets

import android.content.Context
import android.util.AttributeSet
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.ashokvarma.bottomnavigation.ShapeBadgeItem
import com.ashokvarma.bottomnavigation.TextBadgeItem
import com.yiding.kotlin.base.R

class BottomNavBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : BottomNavigationBar(context, attrs, defStyleAttr) {

    private val mCartBadge: TextBadgeItem
    private val mMsgBadge: ShapeBadgeItem

    init {
        val homeItem = BottomNavigationItem(
            R.drawable.btn_nav_home_press,
            resources.getString(R.string.nav_bar_home)
        ).setInactiveIconResource(R.drawable.btn_nav_home_normal)
            .setActiveColorResource(R.color.common_blue)
            .setInActiveColorResource(R.color.text_normal)

        val categoryItem = BottomNavigationItem(
            R.drawable.btn_nav_category_press,
            resources.getString(R.string.nav_bar_category)
        ).setInactiveIconResource(R.drawable.btn_nav_category_normal)
            .setActiveColorResource(R.color.common_blue)
            .setInActiveColorResource(R.color.text_normal)

        val cartItem = BottomNavigationItem(
            R.drawable.btn_nav_cart_press,
            resources.getString(R.string.nav_bar_cart)
        ).setInactiveIconResource(R.drawable.btn_nav_cart_normal)
            .setActiveColorResource(R.color.common_blue)
            .setInActiveColorResource(R.color.text_normal)

        mCartBadge = TextBadgeItem()
        cartItem.setBadgeItem(mCartBadge)

        val msgItem = BottomNavigationItem(
            R.drawable.btn_nav_msg_press,
            resources.getString(R.string.nav_bar_msg)
        ).setInactiveIconResource(R.drawable.btn_nav_msg_normal)
            .setActiveColorResource(R.color.common_blue)
            .setInActiveColorResource(R.color.text_normal)

        mMsgBadge = ShapeBadgeItem()
        msgItem.setBadgeItem(mMsgBadge)
        mMsgBadge.setShape(ShapeBadgeItem.SHAPE_OVAL)

        val userItem = BottomNavigationItem(
            R.drawable.btn_nav_user_press,
            resources.getString(R.string.nav_bar_user)
        ).setInactiveIconResource(R.drawable.btn_nav_user_normal)
            .setActiveColorResource(R.color.common_blue)
            .setInActiveColorResource(R.color.text_normal)

        setMode(BottomNavigationBar.MODE_FIXED)
        setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
        setBarBackgroundColor(R.color.common_white)

        addItem(homeItem).addItem(categoryItem).addItem(cartItem).addItem(msgItem).addItem(userItem)
            .setFirstSelectedPosition(0).initialise()
    }

    fun checkCardBadge(count: Int) {
        if (count == 0) {
            mCartBadge.hide()
        } else {
            mCartBadge.show()
            mCartBadge.setText("$count")
        }
    }

    fun checkMsgBadge(isVisible: Boolean) {
        if (isVisible) {
            mMsgBadge.show()
        } else {
            mMsgBadge.hide()
        }
    }
}