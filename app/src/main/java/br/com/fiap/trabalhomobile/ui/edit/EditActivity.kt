package br.com.fiap.trabalhomobile.ui.edit

import android.os.Bundle
import android.util.Log

import androidx.appcompat.app.AppCompatActivity
import br.com.fiap.trabalhomobile.R
import br.com.fiap.trabalhomobile.model.Filme
import br.com.fiap.trabalhomobile.util.RetrofitInitializer
import kotlinx.android.synthetic.main.activity_edit.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class EditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        var bundle :Bundle ?=intent.extras
        var user_email = bundle!!.getString("USER_EMAIL")


        btEditSave.setOnClickListener{
            val idFilme = inputEditId.text.toString().toInt()
            var filme: Filme = Filme()
            filme.title = inputNewTitle.text.toString()
            filme.usuario = user_email!!

            val call = RetrofitInitializer().filmeService().editFilm(idFilme, filme)

            call.enqueue(object: Callback<Filme> {
                override fun onResponse(call: Call<Filme>?, response: Response<Filme>?) {
                    Log.e("onResponse", " success")
                }

                override fun onFailure(call: Call<Filme>?, t: Throwable?) {
                    Log.e("onFailure error", t?.message)
                }
            })

            finish()
        }

        btEditBack.setOnClickListener{
            finish()
        }

    }
}
