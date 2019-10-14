package br.com.fiap.trabalhomobile.ui.delete

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import br.com.fiap.trabalhomobile.R
import br.com.fiap.trabalhomobile.model.Filme
import br.com.fiap.trabalhomobile.util.RetrofitInitializer
import kotlinx.android.synthetic.main.activity_delete.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DeleteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete)

        var bundle :Bundle ?=intent.extras
        var user_email = bundle!!.getString("USER_EMAIL")

        btDeleteDelete.setOnClickListener{
            val idFilme = inputDeleteId.text.toString().toInt()
            val call = RetrofitInitializer().filmeService().deleteFilm(idFilme)

            call.enqueue(object: Callback<String> {
                override fun onResponse(call: Call<String>?, response: Response<String>?) {
                    Log.e("onResponse", " success")
                }

                override fun onFailure(call: Call<String>?, t: Throwable?) {
                    Log.e("onFailure error", t?.message)
                }
            })

            finish()
        }

        btDeleteBack.setOnClickListener{
            finish()
        }

    }

}
