package com.example.little_lemon.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.little_lemon.ui.theme.PrimaryGreen

@Composable
fun UserDataRow(label: String, value: String, onValueChange: (String) -> Unit, canEdit:Boolean = true) {
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(text = label)
        OutlinedTextField(
            enabled = canEdit,
            value = value,
            onValueChange = {
                onValueChange(it)
            },
            singleLine = true,
            placeholder = { Text(text = label) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedLabelColor = PrimaryGreen,
                focusedBorderColor = PrimaryGreen
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}