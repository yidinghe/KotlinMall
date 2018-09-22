package com.yiding.kotlin.base.ext

import android.view.View
import android.widget.Button
import android.widget.EditText
import com.trello.rxlifecycle.LifecycleProvider
import com.yiding.kotlin.base.data.protocol.BaseResp
import com.yiding.kotlin.base.rx.BaseFunc
import com.yiding.kotlin.base.rx.BaseFuncBoolean
import com.yiding.kotlin.base.rx.BaseSubscriber
import com.yiding.kotlin.base.widgets.DefaultTextWatcher
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

fun <T> Observable<T>.execute(subscriber: BaseSubscriber<T>,
                              lifecycleProvider: LifecycleProvider<*>) {

    this.observeOn(AndroidSchedulers.mainThread())
            .compose(lifecycleProvider.bindToLifecycle())
            .subscribeOn(Schedulers.io())
            .subscribe(subscriber)
}

fun <T> Observable<BaseResp<T>>.convert(): Observable<T> {
    return this.flatMap(BaseFunc())
}

fun <T> Observable<BaseResp<T>>.convertBoolean(): Observable<Boolean> {
    return this.flatMap(BaseFuncBoolean())
}

fun View.onClick(method: () -> Unit) {
    this.setOnClickListener { method() }
}

fun Button.enable(et: EditText, method: () -> Boolean) {
    et.addTextChangedListener(object : DefaultTextWatcher() {
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            this@enable.isEnabled = method()
        }
    })
}