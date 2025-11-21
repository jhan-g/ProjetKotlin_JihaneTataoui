package com.example.projetkotlin.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.projetkotlin.R
import com.example.projetkotlin.ui.theme.blue
import com.example.projetkotlin.ui.theme.darkPink
import com.example.projetkotlin.ui.theme.lightPink
import com.example.projetkotlin.ui.theme.pink

@Composable
fun HomeScreen(navController: NavController, onGetStarted: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(lightPink)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(30.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Num Num",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 24.sp,
                    color = darkPink
                )
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "Panier",
                    tint = darkPink,
                    modifier = Modifier.size(26.dp)
                )

            }

            Spacer(modifier = Modifier.height(50.dp))

            Text(
                buildAnnotatedString {

                    append("L’")

                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = darkPink)) {
                        append("ESSENTIEL ")
                    }

                    append("pour votre\n")

                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = pink)) {
                        append("CHAT")
                    }

                    append(", en un ")

                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = blue)) {
                        append("CLIC")
                    }

                    append(".")
                },
                fontSize = 24.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Start,
                lineHeight = 34.sp
            )

            Spacer(modifier = Modifier.height(30.dp))

            Spacer(modifier = Modifier.height(28.dp))

            Card(
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img),
                    contentDescription = "Chat",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(500.dp)
                        .fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.height(70.dp))

            Button(
                onClick = onGetStarted,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = pink
                )
            ) {
                Text(
                    text = "Get Started",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 18.sp
                )
            }
        }
    }
}
