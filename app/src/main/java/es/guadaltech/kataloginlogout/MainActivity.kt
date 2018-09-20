package es.guadaltech.kataloginlogout

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn_login.setOnClickListener { onLogin(et_user.text.toString(),et_pass.text.toString()) }

    }

    private fun onLogin(user: String, password: String) {

        val kataApp = KataApp(Clock())

        val loginResult = kataApp.onLogin(user,password)

        when (loginResult) {
            KataApp.LoginResult.Success -> {
                et_user.setText("")
                et_pass.setText("")
                et_user.visibility = View.INVISIBLE
                et_pass.visibility = View.INVISIBLE
                btn_login.text = getString(R.string.logout)
                btn_login.setOnClickListener { onLogOut() }
            }
            KataApp.LoginResult.InvalidCredentials -> Toast.makeText(this,R.string.wrong_credentials, Toast.LENGTH_SHORT).show()
            else -> Toast.makeText(this,R.string.wrong_user, Toast.LENGTH_SHORT).show()
        }

    }

    private fun onLogOut() {

        val kataApp = KataApp(Clock())

        if(kataApp.onLogout()){
            et_user.visibility = View.VISIBLE
            et_pass.visibility = View.VISIBLE
            btn_login.text = getString(R.string.login)
            btn_login.setOnClickListener { onLogin(et_user.text.toString(),et_pass.text.toString()) }
        }else{
            Toast.makeText(this,R.string.wrong_time_logout, Toast.LENGTH_SHORT).show()
        }


    }


}
