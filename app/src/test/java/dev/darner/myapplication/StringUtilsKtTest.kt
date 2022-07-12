package dev.darner.myapplication


import org.junit.Assert.*
import org.junit.Test
import java.time.LocalTime

internal class StringUtilsKtTest {

    @Test
    fun `should return a humanreadble string of time`() {
        val now = LocalTime.of(6,0)
        val timeString = now.toHumanSpokenString()
        assertEquals( "six", timeString)
    }

    @Test
    fun `should show midnight at midnight`() {
        val now = LocalTime.of(0,0)
        val timeString = now.toHumanSpokenString()
        assertEquals( "midnight", timeString)
    }

    @Test
    fun `should show afternoon hours correctly`() {
        val now = LocalTime.of(17,0)
        val timeString = now.toHumanSpokenString()
        assertEquals( "five", timeString)
    }

    @Test
    fun `should return a humanreadble string from a time with minutes`() {
        val now = LocalTime.of(17,20)
        val timeString = now.toHumanSpokenString()
        assertEquals( "five twenty", timeString)
    }

    @Test
    fun `should return a humanreadble string from a time with minutes with correct hour`() {
        val now = LocalTime.of(17,50)
        val timeString = now.toHumanSpokenString()
        assertEquals( "ten to six", timeString)
    }
}