package com.ssstor.guesslocation.ui.main

import android.view.View
import com.ssstor.guesslocation.data.entities.GLevel
import com.ssstor.guesslocation.repo.MainRepo

class MainPresenter(view:MainContract.View): MainContract.Presenter{

    init {
        getFirstTenLevels()
    }

    override fun getFirstTenLevels() {
        Thread {
            fun onTenLevelsFetched(tenLevels: List<GLevel>) {
                val tmpList = tenLevels
            }

            fun onError() {
                val e = 1
            }

           MainRepo.getTenLevels(
               1,
                onSuccess = ::onTenLevelsFetched,
                onError = ::onError
            )
        }.start()
    }
}