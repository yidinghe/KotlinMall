package com.yiding.kotlin.mall.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.yiding.kotlin.mall.R

import kotlinx.android.synthetic.main.activity_main.*
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mBottomNavBar.checkMsgBadge(false)
        mBottomNavBar.checkCardBadge(20)

        Observable.timer(2, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread())
            .subscribe { mBottomNavBar.checkMsgBadge(true) }

        Observable.timer(5, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread())
            .subscribe { mBottomNavBar.checkCardBadge(0) }
    }

}
