package br.com.fiap.trabalhomobile.ui.about

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fiap.trabalhomobile.R
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        btAboutBack.setOnClickListener{
            finish()
        }
    }



}
