package com.shortreels.data.remote.api

import com.shortreels.data.remote.dto.ExtractorStreamResponse
import com.shortreels.data.remote.dto.ExtractorVideoDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ExtractorApi {
    @GET("stream")
    suspend fun getStream(
        @Query("url") videoUrl: String,
        @Query("quality") quality: String = "1080p",
        @Query("profile") profile: String = "balanced"
    ): Response<ExtractorStreamResponse>

    @GET("search")
    suspend fun search(
        @Query("q") query: String,
        @Query("page") page: Int = 1,
        @Query("page_size") pageSize: Int = 20
    ): Response<List<ExtractorVideoDto>>
}
