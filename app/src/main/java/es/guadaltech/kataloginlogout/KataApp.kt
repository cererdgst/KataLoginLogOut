package es.guadaltech.kataloginlogout

class KataApp {

    fun onLogin(user: String, password: String): Boolean {
        return "admin" == user && "admin" == password
    }
}