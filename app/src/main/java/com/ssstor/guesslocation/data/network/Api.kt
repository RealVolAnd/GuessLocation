package com.ssstor.guesslocation.data.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("files/{page}.json")
    fun getNextTenLevels(
        @Path("page") page: Int = 0
    ): Call<GetTenLevels>
}