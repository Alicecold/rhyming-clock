package dev.darner.rhymingclock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.darner.rhymingclock.ui.theme.RhymingClockTheme
import kotlinx.coroutines.delay
import java.time.LocalTime
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            RhymingClockTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    PresentTime()
                }
            }
        }
    }
}

@OptIn(ExperimentalTime::class)
@Composable
fun PresentTime() {
    var time by remember { mutableStateOf(LocalTime.now().toHumanSpokenString()) }
    LaunchedEffect(Unit) {
        while(true) {
            delay(Duration.seconds(1))
            time = LocalTime.now().toHumanSpokenString()
        }
    }
    Text(text = "It's $time!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RhymingClockTheme {
        PresentTime()
    }
}