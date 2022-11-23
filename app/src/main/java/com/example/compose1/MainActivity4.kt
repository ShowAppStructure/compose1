package com.example.compose1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose1.ui.theme.Compose1Theme
import kotlin.random.Random

class MainActivity4 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val colorSelected =
                remember {
                    mutableStateOf(value = Color.Yellow)
                }
//            ColorBox(modifier = Modifier.fillMaxSize())
            ColorBox2(modifier = Modifier.fillMaxSize() ){
                colorSelected.value=it
            }
        }
    }
}

@Composable
fun ColorBox(modifier: Modifier) {
    val colorSelected =
        remember {
        mutableStateOf(value = Color.Yellow)
    }

    Box(modifier = modifier
        .background(colorSelected.value)
        .clickable {
            colorSelected.value = Color(
                Random.nextFloat(),
                Random.nextFloat(),
                Random.nextFloat(),
            )
        })
}
@Composable
fun ColorBox2(modifier: Modifier,colorUpdate :(Color)->Unit) {
    Box(modifier = modifier
        .background(Color.Red)
        .clickable {
            colorUpdate(
                Color(Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat())
            )
        })
}