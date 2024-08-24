package com.example.littlelemon2.composables

import SKK.littlelemon.Data.MenuViewModel
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Chip
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon2.destination.Profile
import com.example.littlelemon2.ui.theme.HighlightGray
import com.example.littlelemon2.ui.theme.LittleLemonTheme
import com.example.littlelemon2.ui.theme.PrimaryGreen

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Home(navController: NavController) {
    val menuVm: MenuViewModel = viewModel()
    val menuItems = menuVm.getAllDatabaseMenuItems().observeAsState(emptyList()).value

    var searchPhrase by remember {
        mutableStateOf("")
    }

    var selectedMenuCategory by remember {
        mutableStateOf<String?>(null)
    }


    val filteredMenuItem = menuItems.sortedBy { it.title }.run {
        if (searchPhrase.isNotBlank()) {
            filter { it.title.contains(searchPhrase, ignoreCase = true) }
        } else this
    }.run {
        selectedMenuCategory?.let { category ->
            filter { it.category == category }
        } ?: this
    }

    val filteredCategories = filteredMenuItem.map { it.category }.distinct()



    LaunchedEffect(key1 = Unit) {
        menuVm.fetchMenuDataIfNeeded()
    }
    Column(Modifier.fillMaxSize()) {
        Header(
            isUserLogged = true,
            onUserIconClick = { navController.navigate(Profile.route) }
        )

        HeroCard(
            searchPhrase = searchPhrase,
            onSearchPhraseChange = { searchPhrase = it }
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(spacing),
            modifier = Modifier.padding(padding)
        ) {

            Column {
                Text(
                    text = "ORDER FOR DELIVERY!",
                    style = MaterialTheme.typography.h3,
                    fontWeight = FontWeight.Bold,
                )

                LazyRow(horizontalArrangement = Arrangement.spacedBy(spacing / 2)) {
                    items(filteredCategories) { category ->
                        val isSelected = selectedMenuCategory == category
                        Chip(
                            colors = ChipDefaults.chipColors(
                                backgroundColor = if (isSelected) PrimaryGreen else HighlightGray,
                            ),
                            onClick = {
                                selectedMenuCategory = category
                            }) {
                            Text(
                                color = if (isSelected) Color.White else PrimaryGreen,
                                text = category.toUpperCase(Locale.current)
                            )
                        }
                        if (isSelected) {
                            Chip(onClick = {
                                selectedMenuCategory = null
                            }) {
                                Text("X")
                            }
                        }
                    }
                }


            }

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(spacing / 2)
            ) {
                items(filteredMenuItem) { menuItem ->
                    MenuItem(menuItem)
                }
            }
        }
    }
}

@Composable
@Preview
fun HomePreview() {
    LittleLemonTheme {
        Surface {
            Home(navController = rememberNavController())
        }
    }
}