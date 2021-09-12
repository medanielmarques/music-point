package com.musicpoint.webservices

import com.musicpoint.models.Artist
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ArtistService {

        @GET("search.php")
        fun getArtist(@Query("s") name: String) : Call<Artist>

}

class ArtistConnection {
    private val retrofit = Retrofit.Builder()
        .baseUrl(("https://www.theaudiodb.com/api/v1/json/1/"))
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val artistService = retrofit.create(ArtistService::class.java)
}