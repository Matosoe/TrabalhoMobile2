package br.com.fiap.trabalhomobile.ui.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.fiap.trabalhomobile.ui.menu.MenuActivity
import br.com.fiap.trabalhomobile.ui.signup.SignUpActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T





class LoginActivity : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    private val newUserRequestCode = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(br.com.fiap.trabalhomobile.R.layout.activity_login)
        mAuth = FirebaseAuth.getInstance()

        //TESTE - reativar quando for a versão final

        /*if (mAuth.currentUser != null) {
            goToHome()
        }*/
        btLogin.setOnClickListener {
            mAuth.signInWithEmailAndPassword(
                    inputLoginEmail.text.toString(),
                    inputLoginPassword.text.toString()
            ).addOnCompleteListener {
                if (it.isSuccessful) {
                    val intent = Intent(this, MenuActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    val user_email = inputLoginEmail.text.toString()
                    intent.putExtra("USER_EMAIL", user_email)

                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, it.exception?.message,
                            Toast.LENGTH_SHORT).show()
                }
            }
        }

        tvSignUp.setOnClickListener{
            startActivityForResult(Intent(this, SignUpActivity::class.java),
                    newUserRequestCode)
        }

    }

    private fun onSignUpClick(){
        startActivityForResult(Intent(this, SignUpActivity::class.java),
                newUserRequestCode)
    }
    private fun goToHome() {
        val intent = Intent(this, MenuActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
        finish()
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == newUserRequestCode && resultCode == Activity.RESULT_OK) {
            inputLoginEmail.setText(data?.getStringExtra("email"))
        }
    }
}


