package com.kikesf.androidadventures.superheroApp.data.model

data class SuperHeroData(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<Result>
)
