package com.ajh.kotlinmvp.mvp.model

import com.ajh.kotlinmvp.mvp.model.bean.HomeBean
import com.ajh.kotlinmvp.net.RetrofitManager
import com.ajh.kotlinmvp.rx.scheduler.SchedulerUtils
import io.reactivex.Observable

/**
 * Created by xuhao on 2017/11/30.
 * desc: 排行榜 Model
 */
class RankModel {

    /**
     * 获取排行榜
     */
    fun requestRankList(apiUrl:String): Observable<HomeBean.Issue> {

        return RetrofitManager.service.getIssueData(apiUrl)
                .compose(SchedulerUtils.ioToMain())
    }

}
