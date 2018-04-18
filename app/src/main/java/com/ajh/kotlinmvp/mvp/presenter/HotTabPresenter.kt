package com.ajh.kotlinmvp.mvp.presenter

import com.ajh.kotlinmvp.base.BasePresenter
import com.ajh.kotlinmvp.mvp.contract.HotTabContract
import com.ajh.kotlinmvp.mvp.model.HotTabModel
import com.ajh.kotlinmvp.net.exception.ExceptionHandle

/**
 * Created by xuhao on 2017/11/30.
 * desc: 获取 TabInfo Presenter
 */
class HotTabPresenter : BasePresenter<HotTabContract.View>(), HotTabContract.Presenter {

    private val hotTabModel by lazy { HotTabModel() }

    override fun getTabInfo() {
        checkViewAttached()
        val disposable = hotTabModel.getTabInfo()
                .subscribe({ tabInfo ->
                    mRootView?.setTabInfo(tabInfo)
                }, { throwable ->
                    //处理异常
                    mRootView?.showError(ExceptionHandle.handleException(throwable), ExceptionHandle.errorCode)
                })
        addSubscription(disposable)
    }
}