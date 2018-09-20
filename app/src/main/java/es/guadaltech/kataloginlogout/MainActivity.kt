package es.guadaltech.kataloginlogout

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn_login.setOnClickListener { onLogin(et_user.text.toString(),et_pass.text.toString()) }

    }

    private fun onLogin(user: String, password: String) {

        if("admin" == user && "admin" == password){
            et_user.setText("")
            et_pass.setText("")
            btn_login.text = getString(R.string.logout)
            btn_login.setOnClickListener { onLogOut() }
        }else{
            Toast.makeText(this,R.string.wrong_credentials, Toast.LENGTH_SHORT).show()
        }

    }

    private fun onLogOut() {
        btn_login.text = getString(R.string.login)
        btn_login.setOnClickListener { onLogin(et_user.text.toString(),et_pass.text.toString()) }
    }


}
