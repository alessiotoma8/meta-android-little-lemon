package com.example.littlelemon2.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun YellowButton(label: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        modifier = Modifier
            .padding(padding)
            .fillMaxWidth()
            .height(50.dp),
        onClick = onClick
    ) {
        Text(text = label)
    }
}