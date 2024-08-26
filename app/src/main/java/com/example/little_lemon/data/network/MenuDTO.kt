package com.example.little_lemon.data.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class MenuDTO(
    @SerialName("menu")
    val items: List<MenuItemNetwork>,
)

@Serializable
data class MenuItemNetwork(
    @SerialName("id")
    val id: Int,

    @SerialName("title")
    val title: String,

    @SerialName("description")
    val description: String,

    @SerialName("price")
    val price: Double,

    @SerialName("category")
    val category: String,

    @SerialName("image")
    val imageUrl: String,
)

