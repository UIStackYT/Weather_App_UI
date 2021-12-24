package com.uistack.composedemo2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uistack.composedemo2.ui.screens.HomeScreenUI
import com.uistack.composedemo2.ui.screens.SplashScreenUI
import com.uistack.composedemo2.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemo2Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = PrimaryBackground, modifier = Modifier.fillMaxSize()) {
                    HomeScreenUI()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeDemo2Theme {
        Surface(Modifier.fillMaxSize()) {

        HomeScreenUI()
        }
    }
}