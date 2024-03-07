package com.kikesf.androidadventures.superheroApp.data.model

data class Stories(
    val available: Int,
    val collectionURI: String,
    val items: List<StoryItem>,
    val returned: Int
)