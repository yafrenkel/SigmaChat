package com.sbrobotics.chat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

class AnimationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimateScreen ()
        }
    }
}

enum class BoxState {
    Start,
    End
}

@Composable
fun AnimateScreen () {
    var boxState by remember {
        mutableStateOf(BoxState.Start)
    }

    val offsetBlue:Dp by animateDpAsState(

      //  targetValue = 300.dp
        targetValue =  if (boxState == BoxState.Start) 5.dp
         else 300.dp,
        animationSpec = tween(
            durationMillis = 1000,
            delayMillis = 500,
            //   easing = LinearOutSlowInEasing
            easing = CubicBezierEasing(.95f,0f,.5f,.2f)
        )

    )

    val offset:Dp by animateDpAsState(

      //  targetValue = 5.dp
           targetValue = if (boxState == BoxState.Start) 300.dp
            else 5.dp,
        animationSpec = tween(
            durationMillis = 1000,
            delayMillis = 500,
            //   easing = LinearOutSlowInEasing
            easing = CubicBezierEasing(.95f,0f,.5f,.2f)
        )

    )
    Column (modifier = Modifier.fillMaxSize()){
        Box(color = Color.Red, offset = offset)
        Box(color = Color.Blue, offset = offsetBlue)
        Button (onClick = {boxState = when(boxState) {
            BoxState.Start -> BoxState.End
            BoxState.End -> BoxState.Start
        } }, modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(align = Alignment.BottomCenter)
        ) {
            Text ("Play")
        }

    }
}

@Composable
fun AnimateScreenFull () {
   var boxState by remember {
       mutableStateOf(BoxState.Start)
   }

    val offsetBlue:Dp by animateDpAsState (
        targetValue = if (boxState == BoxState.Start) 300.dp
        else 5.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioHighBouncy,
            stiffness = Spring.StiffnessMedium
        )
    )
    val offset:Dp by animateDpAsState(

        targetValue = if (boxState == BoxState.Start) 5.dp
        else 300.dp,
        animationSpec = tween(
            durationMillis = 1000,
            delayMillis = 500,
            //   easing = LinearOutSlowInEasing
            easing = CubicBezierEasing(.95f,0f,.5f,.2f)
        )
       /* animationSpec = spring(
            dampingRatio = Spring.DampingRatioHighBouncy,
            stiffness = Spring.StiffnessMedium
        )*/
        // option 1 - sping
        /*animationSpec = spring(
            dampingRatio = Spring.DampingRatioHighBouncy,
            stiffness = Spring.StiffnessMedium
        )*/
        //option 2 - tween
        /*
        tween(
    durationMillis: Int = DefaultDurationMillis,
    delayMillis: Int = 0,
    easing: Easing = FastOutSlowInEasing
)
         */

 /*               animationSpec = tween(
                    durationMillis = 1000,
                    delayMillis = 500,
                 //   easing = LinearOutSlowInEasing
                easing = CubicBezierEasing(.95f,0f,.5f,.2f)
            )*/
    )
    Column (modifier = Modifier.fillMaxSize()){
        Box(color = Color.Red, offset = offset)
        Box(color = Color.Blue, offset = offsetBlue)
        Button (onClick = {boxState = when(boxState) {
            BoxState.Start -> BoxState.End
            BoxState.End -> BoxState.Start
        }}, modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(align = Alignment.BottomCenter)
        ) {
            Text ("Play")
        }

    }
}

@Composable
fun ExampleBox(shape: Shape, offset: Dp){
    Box(
        modifier = Modifier
            .size(50.dp)
            .clip(shape)
            .background(Color.Red)
            .padding(start = 16.dp)
            .absoluteOffset(x = offset),

        )
}

@Composable
fun ExampleBoxWithOffset(shape: Shape, offset: Dp){
    Box(
        modifier = Modifier
            .size(50.dp)
            .clip(shape)
            .background(Color.Red)
            .padding(start = 16.dp)
            .absoluteOffset(x = offset)
    )

}

@Composable
fun Box(modifier: Modifier = Modifier,
             color: Color = Color.Red, offset: Dp){
    Surface(
        modifier = modifier
            .size(50.dp)
            .padding(start = 16.dp)
            .absoluteOffset(x = offset),
        color = color,
        content = {}
    )

}


@Composable
fun MyObject(modifier: Modifier = Modifier,
             color: Color = Color.Red, offset: Dp){
    Surface(
        modifier = modifier
            .size(50.dp)
            .padding(start = 16.dp)
            .absoluteOffset(x = offset),
        color = color,
        content = {}
    )

}

@Composable
fun Circle(modifier: Modifier = Modifier,
             color: Color = Color.Blue, offset: Dp){
    Surface(
        modifier = modifier
            .size(50.dp)
            .padding(start = 16.dp)
            .absoluteOffset(y = offset/*, y = offset*/),
        color = color,
        content = {}
    )

}