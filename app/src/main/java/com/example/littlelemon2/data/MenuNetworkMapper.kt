package com.example.littlelemon2.data

import com.example.littlelemon2.data.cache.MenuItemRoom
import com.example.littlelemon2.data.network.MenuNetwork

fun MenuNetwork.toMenuItemRoom() = items.map {
    MenuItemRoom(
        id = it.id,
        title = it.title,
        description = it.description,
        price = it.price,
        category = it.category,
        imageUrl = it.imageUrl
    )
}