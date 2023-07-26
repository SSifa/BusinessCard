package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.android_logo)
    val img1 = painterResource(id = R.drawable.baseline_phone_24)
    val img2 = painterResource(id = R.drawable.ic_baseline_person_24)
    val img3 = painterResource(id = R.drawable.ic_baseline_email_24)
    Box(modifier = modifier.fillMaxSize().background(color = Color(0xa3eacc00)))
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = image,
                contentDescription = null,
                modifier.height(300.dp),
                contentScale = ContentScale.Crop
            )
            Text(text = "Ngombo Kithi Kalu",
            fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            Text(text = "Android App Developer",
                color = Color(0xFF3ddc84))
        }
        Spacer(modifier = modifier.height(100.dp))
        Column(
            verticalArrangement = Arrangement.Bottom
        ) {
            ContactInfo(img = img1, info = "+254 701 249 103")
            ContactInfo(img = img2, info = "@sifa")
            ContactInfo(img = img3, info = "sifangombo254@gmail.com")
        }
    }
}

@Composable
fun ContactInfo(img: Painter, info: String, modifier: Modifier = Modifier){
    Row(horizontalArrangement = Arrangement.Start) {
        Icon(
            painter = img,
            contentDescription = null,
            modifier.padding(8.dp)
        )
        Text(text = info,
            modifier.padding(top = 8.dp, end = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}