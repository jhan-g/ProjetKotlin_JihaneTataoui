package com.example.projetkotlin.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.projetkotlin.ui.theme.PinkDark
import com.example.projetkotlin.ui.theme.PinkLight
import com.example.projetkotlin.ui.theme.PinkPrimaryPro

@Composable
fun LoginScreen(navController: NavController,onNavigateToSignUp: () -> Unit, onLoginSuccess:() -> Unit, onBack:() -> Unit) {

    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PinkLight.copy(alpha = 0.15f))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = PinkDark,
                modifier = Modifier
                    .size(28.dp)
                    .clickable { onBack() }
            )
        }

        Text(
            text = "Login",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = PinkDark,
            modifier = Modifier.padding(top = 20.dp, bottom = 30.dp)
        )

        OutlinedTextField(
            value = email.value,
            onValueChange = { email.value = it },
            label = { Text("Email") },
            placeholder = { Text("Enter your email") },
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = PinkPrimaryPro,
                focusedLabelColor = PinkPrimaryPro,
                cursorColor = PinkPrimaryPro
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(20.dp))

        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text("Password") },
            placeholder = { Text("Enter your password") },
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = PinkPrimaryPro,
                focusedLabelColor = PinkPrimaryPro,
                cursorColor = PinkPrimaryPro
            ),            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(30.dp))

        Button(
            onClick = onLoginSuccess,
            colors = ButtonDefaults.buttonColors(PinkPrimaryPro),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Login", color = Color.White, fontWeight = FontWeight.Bold)
        }

        Spacer(Modifier.height(20.dp))

        Row {
            Text("Don't have an account? ")
            Text(
                "Sign up",
                color = PinkDark,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable { onNavigateToSignUp() }
            )
        }
    }
}

