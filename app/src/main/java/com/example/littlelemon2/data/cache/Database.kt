package com.example.littlelemon2.data.cache

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface MenuItemDao{
    @Query("SELECT * FROM MenuItemRoom")
    fun getAll(): LiveData<List<MenuItemRoom>>

    @Insert
    fun insertAll(menuItems: List<MenuItemRoom>)

    @Query("SELECT (SELECT COUNT(*) FROM MenuItemRoom) == 0")
    fun isEmpty(): Boolean
}

@Database(entities = [MenuItemRoom::class], version = 1)
abstract class AppDatabase: RoomDatabase(){
    abstract fun menuItemDao(): MenuItemDao
}