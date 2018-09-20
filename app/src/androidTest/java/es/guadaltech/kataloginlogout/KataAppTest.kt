package es.guadaltech.kataloginlogout

import android.support.test.runner.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith


import org.junit.Assert.*

@RunWith(AndroidJUnit4::class)
class KataAppTest {

    @Test
    fun onLogin() {

        val kataApp = KataApp()
        assertEquals(kataApp.onLogin("admin","admin"),true)
        assertEquals(kataApp.onLogin("asa","asas"),false)
    }
}