package com.ssstor.guesslocation.data.entities

import com.google.gson.annotations.SerializedName
import com.ssstor.guesslocation.LEVEL_STATUS_LOCKED
import java.io.Serializable

data class GLevel (
    @SerializedName("page")
    var pageNumber: Int = 0,
    @SerializedName("idx")
    var levelIndex: Int = 0,
    @SerializedName("url")
    var levelVideoPath: String = "",
    @SerializedName("coordinates")
    var levelCoordinates: GCoordinates,
    @SerializedName("tryCount")
    var levelTryCount: Int = 0,
    @SerializedName("status")
    var levelStatus: Int = LEVEL_STATUS_LOCKED
):Serializable