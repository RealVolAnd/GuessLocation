package com.ssstor.guesslocation.data.entities

import com.google.gson.annotations.SerializedName

data class GLevel (
    @SerializedName("idx")
    var levelIndex: Int = 0,
    @SerializedName("url")
    var levelVideoPath: String = "",
    @SerializedName("coordinates")
    var levelCoordinates: GCoordinates
  //  var levelTryCount: Int = 0
)