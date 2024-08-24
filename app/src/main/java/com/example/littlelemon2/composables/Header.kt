package com.example.littlelemon2.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.littlelemon2.R

@Composable
fun Header(isUserLogged: Boolean, onUserIconClick: () -> Unit = {}) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = padding)
            .height(80.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            Spacer(Modifier)
            Image(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(),
                contentScale = ContentScale.FillWidth,
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Little Lemon Logo"
            )

            if (isUserLogged) {
                Image(
                    modifier = Modifier
                        .clickable {
                            onUserIconClick()
                        }
                        .fillMaxHeight()
                        .weight(0.2f)
                        .aspectRatio(1f)
                        .clip(CircleShape),
                    contentScale = ContentScale.FillHeight,
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Profile"
                )
            }
        }
    }
}

@Composable
@Preview
fun HeaderPreview() {
    Header(isUserLogged = true)
}