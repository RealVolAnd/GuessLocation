package com.ssstor.guesslocation.ui.main

import com.ssstor.guesslocation.*
import io.reactivex.rxkotlin.subscribeBy


class MainPresenter(view:MainContract.View): MainContract.Presenter{

    init {
      val disposable =  App.instance.getAppStatus().subscribeBy(
            onNext = {
                when(it){
                    APP_STATE_BUSY_FILE ->{
                        view.showBusyFile()
                    }
                    APP_STATE_BUSY_NETWORK ->{
                        view.showBusyNetwork()
                    }
                    APP_STATE_OFFLINE ->{
                        view.goOffline()
                    }
                    APP_STATE_ONLINE ->{
                        view.goOnLine()
                    }
                }
            },
            onError = {
            })
    }
}