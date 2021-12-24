package com.uistack.composedemo2.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uistack.composedemo2.R
import com.uistack.composedemo2.ui.theme.*

@Composable
fun HomeScreenUI() {




    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            text = "Search for city",
            textAlign = TextAlign.Center,
            fontFamily = ReemKufi,
            color = LightText
        )

        SearchBox()
        Cards()
        MoreCitiesButton()
        DataBox()
        
    }
}



@Composable
fun SearchBox() {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = {
            text = it
        },
        label = null,
        placeholder = { Text("Search") },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(top = 20.dp, bottom = 8.dp)
            .clip(SearchShape.medium),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "",
                tint = LightText,
                modifier = Modifier.size(20.dp)
            )
        }
    )
}


@Composable
fun Cards() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(20.dp), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CardUI(
            temperature = "30oC",
            city = "Ciemas",
            resourceId = R.drawable.ic_weather2,
            humidity = "77%",
            wind = "3 km/h"
        )

        CardUI(
            temperature = "25oC",
            city = "Cikaret",
            resourceId = R.drawable.ic_weather2,
            humidity = "45%",
            wind = "4 km/h"
        )
    }
}

@Composable
fun CardUI(temperature: String,city:String,resourceId:Int,humidity:String,wind:String) {
    Card(backgroundColor = White, elevation = 0.dp) {
        Box(
            Modifier
                .width(150.dp)
                .padding(10.dp), contentAlignment = Alignment.TopEnd
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_weather2),
                contentDescription = ""
            )
        }
        Column(modifier = Modifier.padding(20.dp)) {
            Text(text = city, fontFamily = Poppins, fontSize = 14.sp, color = LightText)
            Spacer(modifier = Modifier.height(0.dp))
            Text(
                text = getTemperature(temperature = temperature).toAnnotatedString(),
                fontFamily = Poppins,
                fontSize = 30.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.DarkGray
            )
            Spacer(modifier = Modifier.height(0.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(resourceId),
                    contentDescription = "",
                    Modifier.size(14.dp),
                    tint = LightIcon
                )
                Text(
                    text = humidity,
                    fontFamily = Poppins,
                    fontSize = 12.sp,
                    color = LightText
                )
                Spacer(modifier = Modifier.width(10.dp))
                Icon(
                    painter = painterResource(R.drawable.ic_wind),
                    contentDescription = "",
                    Modifier.size(14.dp),
                    tint = LightIcon
                )
                Text(
                    text = wind,
                    fontFamily = Poppins,
                    fontSize = 12.sp,
                    color = LightText
                )
            }
        }

    }
}

fun getTemperature(temperature: String): AnnotatedString.Builder {
    val annotatedString1 = AnnotatedString.Builder(temperature)
        .apply {
            addStyle(
                SpanStyle(
                    fontSize = 18.sp,
                    baselineShift = BaselineShift.Superscript
                ), 2, 3
            )
        }
    return annotatedString1
}


@Composable
fun MoreCitiesButton() {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            backgroundColor = White,
            contentColor = LightText
        ),
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 6.dp),
        modifier = Modifier.clip(shape = Shapes.small)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "More Cities", fontSize = 14.sp, fontFamily = Poppins)
            Spacer(Modifier.width(10.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_more),
                contentDescription = "",
                tint = LightText,
                modifier = Modifier.size(18.dp)
            )
        }
    }
}

@Composable
fun DataBox() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {

        Card(
            modifier = Modifier
                .padding(top = 80.dp)
                .fillMaxWidth(),
            elevation = 0.dp
        ) {
            Row(
                modifier = Modifier
                    .padding(40.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Precipation",
                        fontFamily = Poppins,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color = LightText
                    )
                    Text(
                        text = "35 %",
                        fontFamily = Poppins,
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Medium,
                        color = DarkGrey
                    )
                    Text(
                        text = "Humidity",
                        fontFamily = Poppins,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color = LightText
                    )
                    Text(
                        text = "30 %",
                        fontFamily = Poppins,
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Medium,
                        color = DarkGrey
                    )
                }
                Spacer(
                    modifier = Modifier
                        .width(1.dp)
                        .height(80.dp)
                        .background(LightText)
                )
                Column {
                    Text(
                        text = "Wind",
                        fontFamily = Poppins,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color = LightText
                    )
                    Text(
                        text = "160",
                        fontFamily = Poppins,
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Medium,
                        color = DarkGrey
                    )
                    Text(
                        text = "Pressure",
                        fontFamily = Poppins,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color = LightText
                    )
                    Text(
                        text = "450hPa",
                        fontFamily = Poppins,
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Medium,
                        color = DarkGrey
                    )
                }
            }
        }

        Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.TopCenter) {
            Image(
                painter = painterResource(id = R.drawable.ic_weather3), contentDescription = "",
                modifier = Modifier.padding(top = 40.dp)
            )
        }
    }
}
