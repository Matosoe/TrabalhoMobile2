package br.com.fiap.trabalhomobile.ui.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fiap.trabalhomobile.ui.about.AboutActivity
import br.com.fiap.trabalhomobile.ui.delete.DeleteActivity
import br.com.fiap.trabalhomobile.ui.edit.EditActivity
import br.com.fiap.trabalhomobile.ui.insert.InsertActivity
import br.com.fiap.trabalhomobile.ui.list.ListActivity
import kotlinx.android.synthetic.main.activity_menu.*
import br.com.fiap.trabalhomobile.R


class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var bundle :Bundle ?=intent.extras
        var user_email = bundle!!.getString("USER_EMAIL")

        btMenuInsert.setOnClickListener{
            val intent = Intent(this, InsertActivity::class.java)
            intent.putExtra("USER_EMAIL", user_email)
            startActivity(intent)
        }

        btMenuList.setOnClickListener{
            val intent = Intent(this, ListActivity::class.java)
            intent.putExtra("USER_EMAIL", user_email)
            startActivity(intent)
        }

        btMenuEdit.setOnClickListener{
            val intent = Intent(this, EditActivity::class.java)
            intent.putExtra("USER_EMAIL", user_email)
            startActivity(intent)
        }

        btMenuDelete.setOnClickListener{
            val intent = Intent(this, DeleteActivity::class.java)
            intent.putExtra("USER_EMAIL", user_email)
            startActivity(intent)
        }

        btMenuExit.setOnClickListener{
            finish()
        }

        btMenuAbout.setOnClickListener{
            startActivityForResult(
                Intent(this, AboutActivity::class.java),1)
        }
    }
}
