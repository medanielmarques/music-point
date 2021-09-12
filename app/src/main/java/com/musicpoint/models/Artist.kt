package com.musicpoint.models

import com.google.gson.annotations.SerializedName

data class Artist (
    // Oi professor, blz? Tivemos que usar um Array aqui
    // pois a API retorna um array de artistas, mesmo buscando um só
    // A API retorna assim -> artists: [{objetoArtista}]
    @SerializedName("artists") val artists: ArrayList<ArtistData>
)

data class ArtistData(
    @SerializedName("strArtist") val name: String,
    @SerializedName("strArtistThumb") val thumb: String,
    @SerializedName("strStyle") val style: String,
    @SerializedName("strGenre") val genre: String,
    @SerializedName("strCountry") val country: String,
)