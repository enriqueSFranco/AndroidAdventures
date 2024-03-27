package com.kikesf.androidadventures.superheroApp.data

import com.kikesf.androidadventures.superheroApp.data.model.SuperHeroResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitService {
    @GET("v1/public/characters?name={name}")
    suspend fun getCharacters(
        @Path("name") superheroName: String,
        @Query("ts") timestamp: String,
        @Query("apiKey") apiKey: String,
        @Query("hash") hash: String
    ): Response<SuperHeroResponse>
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