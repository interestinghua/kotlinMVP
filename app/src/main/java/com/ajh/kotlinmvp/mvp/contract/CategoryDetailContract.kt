package com.ajh.kotlinmvp.mvp.contract

import com.ajh.kotlinmvp.base.IBaseView
import com.ajh.kotlinmvp.base.IPresenter
import com.ajh.kotlinmvp.mvp.model.bean.HomeBean

/**
 * Created by xuhao on 2017/11/30.
 * desc: 分类详情契约类
 */
interface CategoryDetailContract {

    interface View : IBaseView {
        /**
         *  设置列表数据
         *  页面渲染
         */
        fun setCateDetailList(itemList: ArrayList<HomeBean.Issue.Item>)

        fun showError(errorMsg: String)


    }

    interface Presenter : IPresenter<View> {

        /**
         * 网络请求
         */

        fun getCategoryDetailList(id: Long)

        fun loadMoreData()
    }
}