package com.shortreels.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ExtractorStreamResponse(
    @SerializedName("url") val url: String?,
    @SerializedName("audio_url") val audioUrl: String?,
    @SerializedName("hls") val hls: String?
)

data class ExtractorVideoDto(
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("url") val url: String,
    @SerializedName("uploader") val uploader: String,
    @SerializedName("duration") val duration: Long,
    @SerializedName("thumbnail_url") val thumbnailUrl: String,
    @SerializedName("views") val views: Long,
    @SerializedName("age_text") val ageText: String,
    @SerializedName("uploader_url") val uploaderUrl: String,
    @SerializedName("uploader_avatar_url") val uploaderAvatarUrl: String
)
