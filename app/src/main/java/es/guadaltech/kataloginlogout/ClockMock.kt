package es.guadaltech.kataloginlogout

import java.util.*

class ClockMock : Clock() {

    var mockedNow = Calendar.getInstance()

    override var now = mockedNow
}