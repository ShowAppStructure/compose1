package com.example.compose1

import android.graphics.Paint.Style
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //1-todo set custom font
            val fontFamilyExtra = FontFamily(
                Font(R.font.blackitalic, weight = FontWeight.Bold),
                Font(R.font.roboto_thin, weight = FontWeight.Thin),
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = Color.Blue
                    )
                    .padding(20.dp)
            ) {
                Text(
                    //2-todo create a span and set style for multipart text
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color.Red,
                                fontSize = 18.sp
                            )
                        ) {
                            append("FirstLetter")
                        }
                        withStyle(
                            style = SpanStyle(
                                color = Color.Green,
                                fontSize = 18.sp
                            )

                        ) {
                            append("SecondLetter")
                        }
                        append("ThirdLetter")
                    },
                    color = Color.White,
                    fontSize = 15.sp,
                    fontFamily = fontFamilyExtra,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

