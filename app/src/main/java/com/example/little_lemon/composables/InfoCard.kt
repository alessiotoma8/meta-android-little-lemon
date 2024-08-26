package com.example.little_lemon.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.little_lemon.composables.screen.padding
import com.example.little_lemon.ui.theme.PrimaryGreen
import com.example.little_lemon.ui.theme.PrimaryYellow

@Composable
fun InfoCard(title: String? = null, subtitle: String) {
    Column(
        modifier = Modifier
            .fillMaxHeight(0.2f)
            .fillMaxWidth()
            .background(PrimaryGreen)
    ) {
        title?.let {
            Text(
                modifier = Modifier.padding(padding),
                text = title,
                style = MaterialTheme.typography.h1,
                color = PrimaryYellow
            )
        }
        Text(
            modifier = Modifier.padding(padding),
            text = subtitle,
            style = MaterialTheme.typography.h4,
            color = Color.White
        )
    }
}