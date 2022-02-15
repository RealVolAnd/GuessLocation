package com.ssstor.guesslocation.utils

import com.ssstor.guesslocation.*
import com.ssstor.guesslocation.data.entities.SharedPreference

object UtilsSharedPreferences {
    private val sharedPreference: SharedPreference by lazy { initSharedPreferences() }

    private fun initSharedPreferences():SharedPreference{
        return SharedPreference(App.instance)
    }

    fun isNewGame(): Boolean {
        return sharedPreference.getValueString(SHP_USER_UID_KEY) == null
    }

    fun initNewGame() {
        sharedPreference.saveString(SHP_USER_UID_KEY, UtilsMath.getNewUserId())
        sharedPreference.saveInt(SHP_CURRENT_PAGE_NUM_KEY, 1)
        sharedPreference.saveInt(SHP_CURRENT_LEVEL_ID_KEY, 1)
    }

    fun setCurrentLevel(page: Int, level: Int) {
        sharedPreference.saveInt(SHP_CURRENT_PAGE_NUM_KEY, page)
        sharedPreference.saveInt(SHP_CURRENT_LEVEL_ID_KEY, level)
    }

    fun getUserName() = sharedPreference.getValueString(SHP_USER_NAME_KEY)
    fun getUserUid() = sharedPreference.getValueString(SHP_USER_UID_KEY)
    fun getCurrentPage() = sharedPreference.getValueInt(SHP_CURRENT_PAGE_NUM_KEY)
    fun getCurrentLevelId() = sharedPreference.getValueInt(SHP_CURRENT_LEVEL_ID_KEY)
}