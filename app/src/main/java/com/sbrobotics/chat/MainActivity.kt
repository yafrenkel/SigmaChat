package com.sbrobotics.chat

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.Image
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment


import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sbrobotics.chat.ui.theme.ChatTheme
import java.io.File

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContent {

           myApp()
        }
       /* setContent {
            ChatTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Surface(color = Color.Yellow) {
                        Text(text = "Hello KAtya!",
                            modifier = Modifier
                                .background(color = Color.Magenta)
                                .padding(16.dp)
                        )
                    }

                //    Greeting("Android")
                }
            }
        }*/
    }
    fun onCreateOrg(savedInstanceState: Bundle?) {
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
fun myApp(){
    Conversation(SampleData.conversationSample)
}

@Composable
fun myApp1() {
    val toBeGreeted = listOf("a","b","c")
   myScreenContent(toBeGreeted)
    ChatTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
         //   val toBeGreeted = listOf("a","b","c")
            val toBeGreeted = List(1000){"Hello Android $it"}
            myScreenContent(toBeGreeted)
           // Greeting("Android")
        }
    }
}

@Composable
fun myScreenContentAll(names: List<String> =
                        List(1000){"Hello Android $it"}) {
    // vertical layout
    NamesList(names = names, modifier = Modifier)
    Counter()
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
fun myScreenContent(names: List<String> =
                        List(1000){"Hello Android $it"}) {

    // vertical layout
    NamesList(names = names, modifier = Modifier)
    /*Column {
        for (name in names) {
            Greeting (name = name)
            Divider()
        }

        //    Greeting(name = "Android")

        // Greeting(name = "There")
        // for Exercise 2
    //    Counter()
    //    Counter()
    }*/
}
data class Message(val author: String, val body: String)

@Composable
fun MessageCard(msg: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.profile_picture),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondaryVariant, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))

        // We keep track if the message is expanded or not in this
        // variable
        var isExpanded by remember { mutableStateOf(false) }

        // We toggle the isExpanded variable when we click on this Column
        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Text(
                text = msg.author,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )

            Spacer(modifier = Modifier.height(4.dp))

            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 1.dp,
            ) {
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
                    // If the message is expanded, we display all its content
                    // otherwise we only display the first line
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}


@Composable
fun MessageCardSimle(msg: Message) {
    Row {
        Image(
            painter = painterResource(R.drawable.profile_picture),
            contentDescription = "Contact profile picture",
        )

        Column {
            Text(text = msg.author)
            Text(text = msg.body)
        }

    }

}

@Composable
fun MessageCardPrimitive(msg: Message) {
    Text(text = msg.author)
    Text(text = msg.body)
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)


@Preview
@Composable
fun PreviewConversation() {
    ChatTheme() {
        Conversation(SampleData.conversationSample)
    }
}

@Preview
@Composable
fun PreviewMessageCard() {
    MessageCard(
        msg = Message("Colleague", "Hey, take a look at Jetpack Compose, it's great!")
    )
}

@Composable
fun MessageCardComplete(msg: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        androidx.compose.foundation.Image(
            painter = painterResource(R.drawable.profile_picture),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondaryVariant, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))

        // We keep track if the message is expanded or not in this
        // variable
        var isExpanded by remember { mutableStateOf(false) }

        // We toggle the isExpanded variable when we click on this Column
        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Text(
                text = msg.author,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )

            Spacer(modifier = Modifier.height(4.dp))

            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 1.dp,
            ) {
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
                    // If the message is expanded, we display all its content
                    // otherwise we only display the first line
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.body2
                )
            }
        }
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
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message)
        }
    }
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
    Column {
        Button (onClick = {counter++}) {
            Text ("I've been clicked $counter times")
        }
    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  //  myApp()
    ChatTheme {
        Greeting("Android Default")
    }
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
        Column{
            Counter()
            Text(text = "Hello $name!",
                modifier = Modifier
                    .background(color = Color.Magenta)
                    .padding(16.dp)
            )
        }

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






