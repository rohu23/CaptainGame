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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
                    CaptainGame()
                }
            }
        }
    }



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CaptainGameTheme {
        CaptainGame()
    }
}

@Composable
fun CaptainGame(){
    var treasuresFound by remember { mutableIntStateOf(0)}
    var direction by remember { mutableStateOf("North") }
    var stormOrTreasure by remember { mutableStateOf("") }
    var healthPoints by remember { mutableIntStateOf(100) }

    if (healthPoints> 0) {Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.padding(16.dp))
        Text(text = "Treasures Found: $treasuresFound")
        Text(text = "Direction Headed: $direction")
        Text(text = "Health Points: $healthPoints")

        Button(onClick = {
            direction = "North"
            if (Random.nextBoolean()) {
                treasuresFound += 1
                stormOrTreasure = "Found a Treasure!"
            } else {
                stormOrTreasure = "Storm Ahead!"
                healthPoints -= 10
            }
        }) {
            Text(text = "North")
        }
        Button(onClick = {
            direction = "East"
            if (Random.nextBoolean()) {
                treasuresFound += 1
                stormOrTreasure = "Found a Treasure!"
            } else {
                stormOrTreasure = "Storm Ahead!"
                healthPoints -= 10
            }
        }) {
            Text(text = "East")
        }
        Button(onClick = {
            direction = "West"
            if (Random.nextBoolean()) {
                treasuresFound += 1
                stormOrTreasure = "Found a Treasure!"
            } else {
                stormOrTreasure = "Storm Ahead!"
                healthPoints -= 10
            }
        }) {
            Text(text = "West")
        }
        Button(onClick = {
            direction = "South"
            if (Random.nextBoolean()) {
                treasuresFound += 1
                stormOrTreasure = "Found a Treasure!"
            } else {
                stormOrTreasure = "Storm Ahead!"
                healthPoints -= 10
            }
        }) {
            Text(text = "South")
        }
        Text(text = stormOrTreasure)
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
            Button(onClick = { healthPoints = 100
                treasuresFound = 0
                direction = "North"
                stormOrTreasure = "" } ) {
                Text(text = "Restart")
            }

        }
    }
}

