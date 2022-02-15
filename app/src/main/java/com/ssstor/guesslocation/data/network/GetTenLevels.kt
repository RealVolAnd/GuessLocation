package com.ssstor.guesslocation.data.network

import com.google.gson.annotations.SerializedName
import com.ssstor.guesslocation.data.entities.GLevel

data class GetTenLevels(
   @SerializedName("levelList")
   var levelArray:List<GLevel>
)