package br.com.fiap.trabalhomobile.ui.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fiap.trabalhomobile.R
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        var bundle :Bundle ?=intent.extras
        var user_email = bundle!!.getString("USER_EMAIL")

        btListBack.setOnClickListener{
            finish()
        }
    }
}
