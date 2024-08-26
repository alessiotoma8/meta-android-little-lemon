package com.example.little_lemon.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.little_lemon.composables.screen.padding
import com.example.little_lemon.composables.screen.spacing
import com.example.little_lemon.ui.theme.PrimaryGreen
import com.example.little_lemon.ui.theme.PrimaryYellow
import com.example.littlelemon2.R

@Composable
fun HeroCard(searchPhrase:String, onSearchPhraseChange: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(PrimaryGreen)
    ) {
        Column(
            modifier = Modifier.padding(padding),
            verticalArrangement = Arrangement.spacedBy(spacing)
        ) {
            Row(verticalAlignment = Alignment.Bottom) {
                Column(
                    modifier = Modifier.fillMaxWidth(0.7f),
                    verticalArrangement = Arrangement.spacedBy(spacing)
                ) {
                    Column {
                        Text(
                            text = "Little Lemon",
                            style = MaterialTheme.typography.h1,
                            color = PrimaryYellow
                        )

                        Text(
                            text = "Chicago",
                            style = MaterialTheme.typography.h3,
                            color = Color.White
                        )
                    }

                    Text(
                        text = "We are a family-owned Mediterranean restaurant, focused on traditional recipes served with a modern twist",
                        style = MaterialTheme.typography.body2,
                        color = Color.White
                    )
                }

                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.FillBounds,
                    painter = painterResource(id = R.drawable.hero_image),
                    contentDescription = "Little Lemon Image"
                )
            }

            OutlinedTextField(
                value = searchPhrase,
                onValueChange = {
                    onSearchPhraseChange(it)
                },
                placeholder = {
                    Text(text = "Enter Search Phrase")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search Icon")
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor = MaterialTheme.colors.background
                ),
                modifier = Modifier.fillMaxWidth()
            )

        }
    }
}