package com.ajh.kotlinmvp.mvp.model

import com.ajh.kotlinmvp.mvp.model.bean.HomeBean
import com.ajh.kotlinmvp.net.RetrofitManager
import com.ajh.kotlinmvp.rx.scheduler.SchedulerUtils
import io.reactivex.Observable

/**
 * Created by xuhao on 2017/11/30.
 * desc: 分类详情的 Model
 */
class CategoryDetailModel {

    /**
     * 获取分类下的 List 数据
     */
    fun getCategoryDetailList(id: Long): Observable<HomeBean.Issue> {
        //从io线程切换到主线程
        return RetrofitManager.service.getCategoryDetailList(id)
                .compose(SchedulerUtils.ioToMain())
    }

    /**
     * 加载更多数据
     */
    fun loadMoreData(url: String): Observable<HomeBean.Issue> {
        //从io线程切换到主线程
        return RetrofitManager.service.getIssueData(url)
                .compose(SchedulerUtils.ioToMain())
    }
}