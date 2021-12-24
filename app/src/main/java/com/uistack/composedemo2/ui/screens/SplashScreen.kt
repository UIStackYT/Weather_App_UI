package com.uistack.composedemo2.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uistack.composedemo2.R
import com.uistack.composedemo2.ui.theme.*

@Composable
fun SplashScreenUI() {
    val annotatedString1 = AnnotatedString.Builder("Find your weather predictions in your City")
        .apply {
            addStyle(
                SpanStyle(
                    color = Primary,
                    fontSize = 30.sp
                ), 0, 4
            )
        }

    Box (Modifier.padding(horizontal = 40.dp).padding(top = 180.dp), contentAlignment = Alignment.TopCenter){
        Image(
            painter = painterResource(id = R.drawable.ic_weather1),
            contentDescription = ""
        )
    }

    Box(contentAlignment = Alignment.BottomCenter) {
        Card(
            modifier = Modifier
                .clip(shape = BottomShape.medium)
                .fillMaxWidth()
                .height(350.dp),
            elevation = 10.dp
        ) {
            Column(
                Modifier
                    .padding(top = 40.dp)
                    .padding(horizontal = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = annotatedString1.toAnnotatedString(),
                    fontFamily = ReemKufi,
                    fontSize = 28.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Easy steps to predict the weather and make your day easier",
                    fontFamily = ReemKufi,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    color = LightText
                )

                Spacer(modifier = Modifier.height(36.dp))

                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Primary,
                        contentColor = White
                    ),
                    contentPadding = PaddingValues(horizontal = 30.dp, vertical = 10.dp),
                    modifier = Modifier.clip(shape = Shapes.medium)
                ) {
                    Text(text = "Get Start", fontSize = 18.sp, fontFamily = ReemKufi)
                }
            }
        }
    }
}