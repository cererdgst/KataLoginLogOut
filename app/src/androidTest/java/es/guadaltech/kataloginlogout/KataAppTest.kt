package es.guadaltech.kataloginlogout


import android.support.test.runner.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

@RunWith(AndroidJUnit4::class)
class KataAppTest {

    var nowMock = ClockMock()
    val kataApp = KataApp(nowMock)

    @Test
    fun onLogin() {
        assertEquals(KataApp.LoginResult.Success, kataApp.onLogin("admin", "admin"))
        assertEquals(KataApp.LoginResult.InvalidCredentials, kataApp.onLogin("asa", "asas"))
        assertEquals(KataApp.LoginResult.InvalidUsername, kataApp.onLogin("adm,", "asas"))
    }

    @Test
    fun onLogoutSuccessWithSecond2() {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.SECOND,2)
        giveNowIs(calendar)
        assertEquals(true, kataApp.onLogout())
    }

    @Test
    fun onLogoutErrorWithSecondNot2() {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.SECOND,3)
        giveNowIs(calendar)
        assertEquals(false, kataApp.onLogout())
    }

    @Test
    fun checkUserValidCharacters() {
        assertEquals(true, kataApp.validUser("admin"))
        assertEquals(false, kataApp.validUser("adm!n."))
    }

    fun giveNowIs(calendar: Calendar) {
        nowMock.now = calendar
    }
}