package com.kikesf.androidadventures.superheroApp.data.model

import com.google.gson.annotations.SerializedName

data class SuperHeroResponse(
    @SerializedName("code") val code: Int,
    @SerializedName("status") val statusText: String,
    @SerializedName("copyright") val copyright: String,
    @SerializedName("attributionText") val attributionText: String,
    @SerializedName("attributionHTML") val attributionHTML: String,
    @SerializedName("etag") val etag: String,
    @SerializedName("data") val data: List<SuperHeroData>
)
