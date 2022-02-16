package com.ssstor.guesslocation

import android.app.Application
import android.content.Context
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import com.ssstor.guesslocation.data.entities.GLevel
import com.ssstor.guesslocation.utils.UtilsFiles
import com.ssstor.guesslocation.utils.UtilsNetwork
import com.ssstor.guesslocation.utils.UtilsSharedPreferences
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject

class App: Application() {
    companion object {
        lateinit var instance: App
        var currentUserName = ""
        var currentUserUid = ""
        var currentPage = 1
        var currentLevelId = 1
        var currentPageLevelsList = arrayListOf<GLevel>()
        private var currentAppStatus: BehaviorSubject<Int> = BehaviorSubject.create()
    }
    private val cicerone: Cicerone<Router> by lazy {
        Cicerone.create()
    }
    val navigatorHolder get() = cicerone.getNavigatorHolder()
    val router get() = cicerone.router

    override fun onCreate() {
        super.onCreate()
        instance = this

        if(UtilsSharedPreferences.isNewGame()){
            currentPage = 1
            currentLevelId = 1
            UtilsSharedPreferences.initNewGame()
            loadLevelsFromNetwork()
        } else {
            currentUserName = UtilsSharedPreferences.getUserName().toString()
            currentUserUid = UtilsSharedPreferences.getUserUid().toString()
            currentPage = UtilsSharedPreferences.getCurrentPage()
            currentLevelId = UtilsSharedPreferences.getCurrentLevelId()
            loadLevelsFromFile()
        }
    }

    private fun loadLevelsFromNetwork(){
        setAppStatus(APP_STATE_BUSY_NETWORK)
        UtilsNetwork.getNextTenLevels()
        setAppStatus(APP_STATE_ONLINE)
    }

    private fun loadLevelsFromFile(){
        setAppStatus(APP_STATE_BUSY_FILE)
        UtilsFiles.loadLevels()
        setAppStatus(APP_STATE_ONLINE)
    }

    fun setAppStatus(status:Int){
        currentAppStatus.onNext(status)
    }

    fun getAppStatus() = currentAppStatus

}


val Context.app: App
    get() = applicationContext as App