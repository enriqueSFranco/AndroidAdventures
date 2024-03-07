package com.kikesf.androidadventures.superheroApp.data.model

data class Creators(
    val available: Int,
    val collectionURI: String,
    val comicCreatorItems: List<ComicCreatorItem>,
    val returned: Int
)