package dev.darner.rhymingclock

import java.time.LocalTime
import kotlin.math.roundToInt

fun LocalTime.toHumanSpokenString(): String {
    val hours = listOf(
        "midnight",
        "one",
        "two",
        "three",
        "four",
        "five",
        "six",
        "seven",
        "eight",
        "nine",
        "ten",
        "eleven",
        "noon",
        "one",
        "two",
        "three",
        "four",
        "five",
        "six",
        "seven",
        "eight",
        "nine",
        "ten",
        "eleven"
    )

    val hour = if (this.minute <= 30) hours[this.hour] else hours[(this.hour + 1)]

    val minutes = listOf(
        hour,
        "five past $hour",
        "ten past $hour",
        "quater past $hour",
        "$hour twenty",
        "$hour twenty-five",
        "half past $hour",
        "twenty-five to $hour",
        "twenty to $hour",
        "quater to $hour",
        "ten to $hour",
        "five to $hour",
        hour
    )
    return minutes[this.minute.toDouble().roundToNearest(5)/5]
}
fun Double.roundToNearest(number: Int): Int {
    return ((this / number).roundToInt() * number)
}
