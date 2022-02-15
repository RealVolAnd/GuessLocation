package com.ssstor.guesslocation

import android.app.Application
import android.content.Context
import com.ssstor.guesslocation.data.entities.GLevel
import com.ssstor.guesslocation.utils.UtilsNetwork
import com.ssstor.guesslocation.utils.UtilsSharedPreferences
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject

class App: Application() {
    companion object {
        lateinit var instance: App
        var currentUserName =""
        var currentUserUid =""
        var currentPage = 0
        var currentLevelId = 0
        var currentPageLevelsList = arrayListOf<GLevel>()
        private var currentAppStatus: BehaviorSubject<Int> = BehaviorSubject.create()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this


        if(UtilsSharedPreferences.isNewGame()){
            UtilsSharedPreferences.initNewGame()
            currentPage = 1
            currentLevelId = 1
            UtilsNetwork.getNextTenLevels()
        } else {
            currentUserName = UtilsSharedPreferences.getUserName().toString()
            currentUserUid = UtilsSharedPreferences.getUserUid().toString()
            currentPage = UtilsSharedPreferences.getCurrentPage()
            currentLevelId = UtilsSharedPreferences.getCurrentLevelId()
        }
    }

    private fun setAppStatus(status:Int){
        currentAppStatus.onNext(status)
    }

    fun getAppStatus() = currentAppStatus

}


val Context.app: App
    get() = applicationContext as App