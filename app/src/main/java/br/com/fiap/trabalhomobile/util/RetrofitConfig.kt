package br.com.fiap.trabalhomobile.util

import FilmeService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {
    private val URL = "https://filmes-app.herokuapp.com/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun filmeService(): FilmeService {
        return retrofit.create(FilmeService::class.java)
    }
}