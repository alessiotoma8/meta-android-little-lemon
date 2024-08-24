package com.example.littlelemon2.data.cache

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MenuItemRoom(
    @PrimaryKey
    val id: Int,
    val title: String,
    val description: String,
    val price: Double,
    val category: String,
    val imageUrl: String
)