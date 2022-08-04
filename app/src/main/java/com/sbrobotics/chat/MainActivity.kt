package com.sbrobotics.chat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sbrobotics.chat.ui.theme.ChatTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            myApp()
        }
        /*setContent {
            ChatTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }*/
    }
}


@Composable
fun myApp() {
    ChatTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            myScreenContent()
           /* val toBeGreeted = listOf("a","b","c")
            myScreenContent(toBeGreeted)*/
           // Greeting("Android")
        }
    }
}

@Composable
fun myScreenContent(names: List<String> =
                        List(1000){"Hello Android $it"}) {
    // vertical layout
    NamesList(names = names, modifier = Modifier)
    Column {
        /*for (name in names) {
            Greeting (name = name)
            Divider()
        }

        //    Greeting(name = "Android")

        // Greeting(name = "There")
        // for Exercise 2
        Counter()
        Counter()*/
    }
}

@Composable
fun NamesList(names: List<String>, modifier: Modifier) {
    LazyColumn(modifier = Modifier.fillMaxHeight()) {
        items(items = names) {
            Greeting(name = it)
            Divider()
        }

    }
    /*
    Column(modifier = Modifier.fillMaxHeight()) {
        for (name in names) {
            Greeting(name = name)
            Divider()
        }
    }
     */
}


@Composable
fun myScreenContent1(names: List<String> = listOf("Android", "There")) {
    // vertical layout

    Column {
        for (name in names) {
            Greeting (name = name)
            Divider()
        }

    //    Greeting(name = "Android")

       // Greeting(name = "There")
        // for Exercise 2
        Counter()
        Counter()
    }
}
@Composable
fun Counter() {
 //   var counter = 0
    var counter by remember {
        mutableStateOf(0)
    }
    Button (onClick = {counter++}) {
        Text ("I've been clicked $counter times")
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    myApp()
    /*ChatTheme {
        Greeting("Android")
    }*/
}


@Preview(fontScale = 1.5f)
@Preview(showBackground = true)
@Composable
fun JetChat(name: String = "test") {
    Column {
        Row {
            Text("Ali Conors")
            Text("3:50pm")
        }
        Column {
            Text(text = "Yeah I have been mainly referring"
            + " to the JetNews Sample")

        }
    }

}

@Composable
fun Greeting(name: String) {
    Surface(color = Color.Yellow) {
        Text(text = "Hello $name!",
            modifier = Modifier
                .background(color = Color.Magenta)
                .padding(16.dp)
                )
    }
}


@Composable
fun Greeting1(name: String) {
    Surface(color = Color.Yellow) {
        Text(text = "Hello $name!")
    }
}

@Preview(showBackground = true)
@Composable
fun JetChat1(name: String = "test") {
    Text("Ali Conors")
    Text("3:50pm")
    Text(text = "Yeah Meah ..")
}






