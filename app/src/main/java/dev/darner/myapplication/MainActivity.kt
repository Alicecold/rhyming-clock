package dev.darner.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.darner.myapplication.ui.theme.RhymingClockTheme
import java.time.LocalTime
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val currentTime = LocalTime.now().toHumanSpokenString()
        setContent {
            RhymingClockTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(currentTime)
                }
            }
        }
    }
}

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
        "twelve"
    )

    val hour = if (this.minute <= 30) hours[this.hour] else hours[this.hour + 1]

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
        "five to $hour"
    )
    return minutes[this.minute.toDouble().roundToNearest(5)/5]
}

fun Double.roundToNearest(number: Int): Int {
    return ((this / number).roundToInt() * number)
}

@Composable
fun Greeting(name: String) {
    Text(text = "It's $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RhymingClockTheme {
        Greeting("Android")
    }
}