package br.com.fiap.trabalhomobile.ui.insert

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import br.com.fiap.trabalhomobile.R
import br.com.fiap.trabalhomobile.model.Filme
import br.com.fiap.trabalhomobile.util.RetrofitInitializer
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_insert.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InsertActivity : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)

        var bundle :Bundle ?=intent.extras
        var user_email = bundle!!.getString("USER_EMAIL")


        btInsertInsert.setOnClickListener{

            mAuth = FirebaseAuth.getInstance()

            if (mAuth.currentUser != null) {
                val filme = Filme()
                filme.title = inputTitle.text.toString()
                filme.usuario = user_email!!
                val call = RetrofitInitializer().filmeService().addNewFilm(filme)

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

        }
        btInsertBack.setOnClickListener{
            finish()
        }
    }
}
