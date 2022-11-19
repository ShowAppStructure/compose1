package com.example.compose1

import android.os.Bundle
import android.util.Log
import android.webkit.ConsoleMessage
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentScope.SlideDirection.Companion.Start
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Colors
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign.Companion.Start
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import java.io.Console

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    //1-todo set padding
                    .padding(20.dp)
//                    .fillMaxSize(fraction = 0.5F)
                    .fillMaxHeight(fraction = 0.5f)
//                    .fillMaxWidth(fraction = 0.5F)
                    .width(200.dp)
//                    .requiredWidth(800.dp)
//                    .height(100.dp)
                    .background(color = Color.Red),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.Start,
            )
            {
                //2-todo set margin with offset
                Text(text = "first", Modifier.offset(10.dp))
                //3-todo you can also create margin property with spacer widget
                Spacer(modifier = Modifier.height(300.dp))
                Text(text = "second", Modifier.offset(x = 90.dp))
                //4-todo get click with modifier
                Text(text = "third",
                    Modifier
                        .offset(y = 60.dp)
                        .clickable {
                            Log.d("clickable", "onCreate: clickable")
                        })
            }

            Row(
                modifier = Modifier
                    .fillMaxHeight(fraction = 0.3f)
                    .width(200.dp)
                    .background(color = Color.Green)
                    //5-todo nested padding and border like below
                    .border(5.dp, color = Color.Yellow)
                    .padding(5.dp)
                    .border(15.dp, color = Color.Green)
                    .padding(15.dp)
                    .border(3.dp, color = Color.Blue)
                    .padding(15.dp)

            )
            {
                Text(text = "first", Modifier.offset(10.dp))
                Text(text = "second", Modifier.offset(x = 90.dp))
                Text(
                    text = "third",
                    Modifier
                        .offset(y = 60.dp)
                )
            }
        }
    }
}

//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    Compose1Theme {
//        Greeting("reza")
//    }
//}