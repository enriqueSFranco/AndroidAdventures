package com.kikesf.androidadventures.superheroApp.data.model

import com.google.gson.annotations.SerializedName

data class ComicsItem(
    @SerializedName("resourceURI") val resourceURI: String,
    @SerializedName("name") val name: String
)
