package com.gaps.myapplication.data

import com.gaps.myapplication.data.remote.ModelService
import okhttp3.OkHttpClient
import retrofit2.Retrofit

object RemoteServices {

    fun getRemoteServices(): ModelService {
        return getRetrofit().create(ModelService::class.java)
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("http://www.google.com").client(httpClient()).build()
    }

    private fun httpClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor {
            val request = it.request().newBuilder().header("Cache-Control", "public, max-age=" + 50).build()
            it.proceed(request)
        }.build()
    }
}