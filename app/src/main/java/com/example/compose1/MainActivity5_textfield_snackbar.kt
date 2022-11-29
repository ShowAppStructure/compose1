package com.example.compose1


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose1.ui.theme.Compose1Theme
import kotlinx.coroutines.launch
import kotlin.random.Random


class MainActivity5_textfield_snackbar : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scaffoldStateIns = rememberScaffoldState()
            var textfieldState by remember {
                mutableStateOf("")
            }
            val scope= rememberCoroutineScope()
            Scaffold(modifier = Modifier.fillMaxSize(), scaffoldState = scaffoldStateIns) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    TextField(value = textfieldState,
                        label =
                        {
                        Text(text = "enter Your Text")
                    }, onValueChange = {
                        textfieldState=it
                    }, singleLine = true, modifier = Modifier.fillMaxWidth().offset(x = 20.dp))
                    Spacer(modifier = Modifier.height(15.dp))
                    Button(onClick = {
                        scope.launch {
                            scaffoldStateIns.snackbarHostState.showSnackbar("hello ${textfieldState}")
                        }
                    }) {
                        Text(text = "click on this")
                    }
                }
            }
        }
    }
}

