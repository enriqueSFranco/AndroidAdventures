package com.kikesf.androidadventures.superheroApp.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("v1/public/comics")
    suspend fun listComics(
        @Query("ts") timestamp: String,
        @Query("apiKey") apiKey: String,
        @Query("hash") hash: String

    )
}

object RetrofitServiceFactory {
    fun makeRestrofitService(): RetrofitService {
        return Retrofit
            .Builder()
            .baseUrl("http://gateway.marvel.com/")
            .addConverterFactory(GsonConverterFactory.create()) // convierte el response en json
            .build().create(RetrofitService::class.java)
    }
}