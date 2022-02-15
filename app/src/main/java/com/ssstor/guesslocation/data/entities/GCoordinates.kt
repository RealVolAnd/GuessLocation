package com.ssstor.guesslocation.data.entities

import com.google.gson.annotations.SerializedName

data class GCoordinates (
    @SerializedName("latitude")
    var levelLatitude: Double,
    @SerializedName("longitude")
    var levelLongitude: Double
)