package com.ajh.kotlinmvp.base

/**
 * @author Jake.Ho
 * created: 2017/10/25
 * desc: Presenter 基类
 */

//逆变类型参数作为输入
interface IPresenter<in V : IBaseView> {

    fun attachView(mRootView: V)

    fun detachView()

}
