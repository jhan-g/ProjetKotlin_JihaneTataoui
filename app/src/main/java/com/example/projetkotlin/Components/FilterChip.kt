package com.example.projetkotlin.Components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.projetkotlin.ui.theme.PinkPrimary

@Composable
fun FilterChip(text: String) {
    Box(
        modifier = Modifier
            .background(
                PinkPrimary.copy(alpha = 0.2f),
                RoundedCornerShape(20.dp)
            )
            .padding(horizontal = 14.dp, vertical = 8.dp)
    ) {
        Text(text, color = PinkPrimary, fontWeight = FontWeight.Medium)
    }
}