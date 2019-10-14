import br.com.fiap.trabalhomobile.model.Filme
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface FilmeService {
    @GET("filme/usuario/{usuario}")
    fun getAllFilmsByUser(@Path("usuario")usuario: String): Call<List<Filme>>

    @GET("filme/{id}")
    fun getFilmById(@Path("id")id: Int): Call<Filme>

    @POST("filme/")
    fun addNewFilm(@Body filme: Filme): Call<Filme>

    @PUT("filme/{id}")
    fun editFilm(@Path("id") id: Int, @Body filme: Filme): Call<Filme>

    @DELETE("filme/{id}")
    fun deleteFilm(@Path("id")id: Int): Call<String>
}