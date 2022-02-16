package com.ssstor.guesslocation

import com.ssstor.guesslocation.data.entities.GCoordinates
import com.ssstor.guesslocation.data.entities.GLevel
import io.reactivex.Observable

val SHP_USER_UID_KEY = "uUid"
val SHP_USER_NAME_KEY = "uName"
val SHP_CURRENT_PAGE_NUM_KEY = "cPage"
val SHP_CURRENT_LEVEL_ID_KEY = "cLevel"

val APP_STATE_OFFLINE = 0
val APP_STATE_BUSY_FILE = 1
val APP_STATE_BUSY_NETWORK= 2
val APP_STATE_ONLINE = 3


val USER_UID_LEN = 8

val GAME_LEVELS_COUNT_DEFAULT = 10
val GAME_LIVES_COUNT_DEFAULT = 3
val INET_BASE_URL = "https://ss-stor.com/"

val BLANK_LEVEL = GLevel(0,0,"", GCoordinates(0.0,0.0),0,0)

val LEVEL_STATUS_LOCKED = 0
val LEVEL_STATUS_AVAILABLE = 1
val LEVEL_STATUS_FINISHED = 2
