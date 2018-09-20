package es.guadaltech.kataloginlogout

import java.util.*

class KataApp(var clock: Clock) {


    fun onLogin(user: String, password: String): LoginResult {

        return if(! validUser(user)){
            LoginResult.InvalidUsername
        }else if (!("admin" == user && "admin" == password)){
            LoginResult.InvalidCredentials
        }else{
            LoginResult.Success
        }
    }

    fun validUser(user: String): Boolean {
        return !(user.contains(",") || user.contains(".") || user.contains(";"))

    }

    fun onLogout(): Boolean {
        return clock.now.get(Calendar.SECOND) % 2 == 0
    }

    sealed class LoginResult {
        object Success : LoginResult()
        object InvalidCredentials : LoginResult()
        object InvalidUsername : LoginResult()
    }


}