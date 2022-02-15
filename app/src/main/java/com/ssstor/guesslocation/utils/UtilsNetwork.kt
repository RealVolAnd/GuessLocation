package com.ssstor.guesslocation.utils

import com.ssstor.guesslocation.App
import com.ssstor.guesslocation.R
import com.ssstor.guesslocation.data.entities.GLevel
import com.ssstor.guesslocation.repo.MainRepo

object UtilsNetwork {
    fun getNextTenLevels() {
        Thread {
            fun onTenLevelsFetched(tenLevels: List<GLevel>) {
                App.currentPageLevelsList.clear()
                App.currentPageLevelsList.addAll(tenLevels)
                UtilsFiles.saveLevels()
            }

            fun onError() {
                UtilsMessages.showMessage(App.instance.getString(R.string.network_error_occurred))
            }

            MainRepo.getTenLevels(
                App.currentPage,
                onSuccess = ::onTenLevelsFetched,
                onError = ::onError
            )
        }.start()
    }
}