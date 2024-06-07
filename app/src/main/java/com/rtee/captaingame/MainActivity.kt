package com.rtee.captaingame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rtee.captaingame.ui.theme.CaptainGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CaptainGameTheme {
                    captainGame()
                }
            }
        }
    }



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CaptainGameTheme {
        captainGame()
    }
}

@Composable
fun captainGame(){
    val treasuresFound = remember { mutableIntStateOf(0)}
    val direction = remember { mutableStateOf("North") }
    val stormOrTreasure = remember { mutableStateOf("") }
    val healthPoints = remember { mutableIntStateOf(100) }

    if (healthPoints.intValue > 0) {Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.padding(16.dp))
        Text(text = "Treasures Found: ${treasuresFound.value}")
        Text(text = "Direction Headed: ${direction.value}")
        Text(text = "Health Points: ${healthPoints.value}")

        Button(onClick = {
            direction.value = "North"
            if (Random.nextBoolean()) {
                treasuresFound.value += 1
                stormOrTreasure.value = "Found a Treasure!"
            } else {
                stormOrTreasure.value = "Storm Ahead!"
                healthPoints.value -= 10
            }
        }) {
            Text(text = "North")
        }
        Button(onClick = {
            direction.value = "East"
            if (Random.nextBoolean()) {
                treasuresFound.value += 1
                stormOrTreasure.value = "Found a Treasure!"
            } else {
                stormOrTreasure.value = "Storm Ahead!"
                healthPoints.value -= 10
            }
        }) {
            Text(text = "East")
        }
        Button(onClick = {
            direction.value = "West"
            if (Random.nextBoolean()) {
                treasuresFound.value += 1
                stormOrTreasure.value = "Found a Treasure!"
            } else {
                stormOrTreasure.value = "Storm Ahead!"
                healthPoints.value -= 10
            }
        }) {
            Text(text = "West")
        }
        Button(onClick = {
            direction.value = "South"
            if (Random.nextBoolean()) {
                treasuresFound.value += 1
                stormOrTreasure.value = "Found a Treasure!"
            } else {
                stormOrTreasure.value = "Storm Ahead!"
                healthPoints.value -= 10
            }
        }) {
            Text(text = "South")
        }
        Text(text = stormOrTreasure.value)
    }
    }else{
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            Spacer(modifier = Modifier.padding(16.dp))
            Text(text = "Game Over")
            Button(onClick = { healthPoints.value = 100
                treasuresFound.value = 0
                direction.value = "North"
                stormOrTreasure.value = "" } ) {
                Text(text = "Restart")
            }

        }
    }
}

