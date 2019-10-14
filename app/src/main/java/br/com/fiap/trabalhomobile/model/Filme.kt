package br.com.fiap.trabalhomobile.model
import com.google.gson.annotations.SerializedName;

data class Filme (
    @SerializedName("title")
    var title: String = "",
    @SerializedName("usuario")
    var usuario: String = "",
    @SerializedName("id")
    var id: Int = 0
)