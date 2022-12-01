package com.example.compose1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.example.compose1.ui.theme.Compose1Theme

class MainActivity7_constraint_layout : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val constraints= ConstraintSet{
                val greenBox=createRefFor("greenBox")
                val redBox=createRefFor("redBox")
                val blueBox=createRefFor("blueBox")
                val guideLine=createGuidelineFromTop(0.5f)


                constrain(blueBox){
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    width= Dimension.value(100.dp)
                    height= Dimension.value(100.dp)
                }
                constrain(greenBox){
                    //1- todo you can use guideline instead of parent or name of a ref
                    top.linkTo(guideLine)
                    start.linkTo(blueBox.end)
                    width= Dimension.value(100.dp)
                    height= Dimension.value(100.dp)
                }
                constrain(redBox){
                    top.linkTo(parent.top)
                    start.linkTo(greenBox.end)
                    //2- todo you can use below lines to fill view to end of parent
                    //todo end.linkTo(parent.end)
                    //todo width= Dimension.fillToConstraints
                    width= Dimension.value(100.dp)
                    height= Dimension.value(100.dp)
                }
                //3- todo align items together in the center
                createHorizontalChain(greenBox,redBox, chainStyle = ChainStyle.Packed)
            }
            ConstraintLayout(constraints, modifier = Modifier.fillMaxSize()) {
                Box(modifier = Modifier.background(Color.Blue).layoutId("blueBox"))
                Box(modifier = Modifier.background(Color.Green).layoutId("greenBox"))
                Box(modifier = Modifier.background(Color.Red).layoutId("redBox"))
            }
        }
    }
}

