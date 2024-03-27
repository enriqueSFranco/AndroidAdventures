package com.kikesf.androidadventures.superheroApp.data.model

import com.google.gson.annotations.SerializedName

data class StoriesItem(
    @SerializedName("resourceURI") val resourceURI: String,
    @SerializedName("name") val name: String,
    @SerializedName("type") val type: String
)
