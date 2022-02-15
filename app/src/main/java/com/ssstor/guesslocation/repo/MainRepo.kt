package com.ssstor.guesslocation.repo


import com.ssstor.guesslocation.INET_BASE_URL
import com.ssstor.guesslocation.data.entities.GLevel
import com.ssstor.guesslocation.data.network.Api
import com.ssstor.guesslocation.data.network.GetTenLevels
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Path

object MainRepo {
    private val api: Api

    init {
        val interceptor : HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client : OkHttpClient = OkHttpClient.Builder().apply {
            addInterceptor(interceptor)
        }.build()

        val retrofit = Retrofit.Builder()
            .baseUrl(INET_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        api = retrofit.create(Api::class.java)
    }

    fun getTenLevels(
        @Path("page") page: Int,
        onSuccess: (levelList: List<GLevel>) -> Unit,
        onError: () -> Unit
    ) {
        api.getNextTenLevels(page = page)
            .enqueue(object : Callback<GetTenLevels> {
                override fun onResponse(
                    call: Call<GetTenLevels>,
                    response: Response<GetTenLevels>
                ) {

                    if (response.isSuccessful) {
                        val responseBody = response.body()

                        if (responseBody != null) {
                            onSuccess.invoke(responseBody.levelArray)
                        } else {
                            val e=1
                            onError.invoke()
                        }
                    } else {
                        val e=1
                        onError.invoke()
                    }
                }

                override fun onFailure(call: Call<GetTenLevels>, t: Throwable) {
                    onError.invoke()
                }
            })
    }
}