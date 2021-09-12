package com.musicpoint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.musicpoint.databinding.ActivityArtistBinding
import com.musicpoint.models.Artist
import com.musicpoint.webservices.ArtistConnection
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArtistActivity : AppCompatActivity() {

    lateinit var binding: ActivityArtistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArtistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btSearch.setOnClickListener {
            val name = binding.artistInput.text.toString()
            searchArtist(name)
        }
    }

    private fun searchArtist(name: String) {

        val callback = object : Callback<Artist> {
            override fun onResponse(call: Call<Artist>, response: Response<Artist>) {
                val response = response.body()!!
                val artist = response.artists[0]

                ("Artista: " + artist.name).also { binding.tvArtistName.text = it }
                ("Estilo: " + artist.style).also { binding.tvArtistStyle.text = it }
                ("Gênero: " + artist.genre).also { binding.tvArtistGenre.text = it }
                ("País: " + artist.country).also { binding.tvArtistCountry.text = it }

                Glide.with(this@ArtistActivity)
                    .load(artist.thumb)
                    .into(binding.imgArtist)
            }
            override fun onFailure(call: Call<Artist>, t: Throwable) {
                Toast.makeText(this@ArtistActivity, "Erro ao buscar artista", Toast.LENGTH_SHORT).show()
            }
        }
        ArtistConnection().artistService.getArtist(name).enqueue(callback)
    }
}