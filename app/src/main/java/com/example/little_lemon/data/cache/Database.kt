package com.example.little_lemon.data.cache

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface MenuItemDao{
    @Query("SELECT * FROM MenuItemEntity")
    fun getAll(): LiveData<List<MenuItemEntity>>

    @Insert
    fun insertAll(menuItems: List<MenuItemEntity>)

    @Query("SELECT (SELECT COUNT(*) FROM MenuItemEntity) == 0")
    fun isEmpty(): Boolean
}

@Database(entities = [MenuItemEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase(){
    abstract fun menuItemDao(): MenuItemDao
}