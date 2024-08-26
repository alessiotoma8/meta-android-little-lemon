package com.example.little_lemon.data.util

import com.example.little_lemon.data.cache.MenuItemEntity
import com.example.little_lemon.data.network.MenuDTO

fun MenuDTO.toMenuItemRoom() = items.map {
    MenuItemEntity(
        id = it.id,
        title = it.title,
        description = it.description,
        price = it.price,
        category = it.category,
        imageUrl = it.imageUrl
    )
}