package com.gaps.myapplication.data.remote

import com.gaps.myapplication.models.RemoteModel
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ModelService {
    @GET("URL://")
    suspend fun getModel(): Response<RemoteModel>

    @POST("URL://")
    suspend fun postModel(@Body body: RequestBody): Response<Unit>
}