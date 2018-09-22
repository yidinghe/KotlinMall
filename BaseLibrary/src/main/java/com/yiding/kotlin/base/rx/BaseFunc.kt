package com.yiding.kotlin.base.rx

import com.yiding.kotlin.base.common.ResultCode
import com.yiding.kotlin.base.data.protocol.BaseResp
import rx.Observable
import rx.functions.Func1

class BaseFunc<T> : Func1<BaseResp<T>, Observable<T>> {
    override fun call(t: BaseResp<T>): Observable<T> {
        if (t.status != ResultCode.SUCCESS) {
            return Observable.error<T>(BaseException(t.status, t.message))
        }
        return Observable.just(t.data)
    }
}