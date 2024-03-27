package com.kikesf.androidadventures.superheroApp.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("v1/public/characters?ts=1&apiKey=1342ee46b3a8207e80b268dc4b8f97a1&hash=e7538208ae63bf14cfdf1c6e4ecded44")
    suspend fun listCharacters(
        @Query("ts") timestamp: String,
        @Query("apiKey") apiKey: String,
        @Query("hash") hash: String
    )
}

object RetrofitServiceFactory {
    fun makeRetrofitService(): RetrofitService {
        return Retrofit
            .Builder()
            .baseUrl("http://gateway.marvel.com/")
            .addConverterFactory(GsonConverterFactory.create()) // convierte el response en json
            .build().create(RetrofitService::class.java)
    }
}