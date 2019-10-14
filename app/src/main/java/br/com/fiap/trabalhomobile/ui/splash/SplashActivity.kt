package br.com.fiap.trabalhomobile.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import br.com.fiap.trabalhomobile.R
import br.com.fiap.trabalhomobile.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    private val TEMPO_AGUARDO_SPLASHSCREEN = 3500L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        carregar()
    }
    private fun carregar() {
//Carrega a animacao
        val anim = AnimationUtils.loadAnimation(this, R.anim.animacao_splash)
        anim.reset()
        ivLogo.clearAnimation()
//Roda a animacao
        ivLogo.startAnimation(anim)
//Chama a próxima tela após 3,5 segundos definido na SPLASH_DISPLAY_LENGTH
        Handler().postDelayed({
            //TESTE - AQUI PRECISARÁ VERIFICAR SE O USUARIO PEDIU PARA FICAR CONNECTADO, SE SIM,
            //VERIFICAR O LOGIN DELE (COM O CÓDIGO DO FIREBASE) E SE TUDO ESTIVER OK, IR DIRETO
            //PARA O MAIN

            val proximaTela = Intent(this, LoginActivity::class.java)
            startActivity(proximaTela)
            finish()
        }, TEMPO_AGUARDO_SPLASHSCREEN)
    }
}