package com.android.inventory_codelab.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Item::class], exportSchema = false, version = 1)
abstract class InventoryDatabase: RoomDatabase() {
    abstract fun itemDao() : ItemDao

    companion object{
        @Volatile
        private var Instance: InventoryDatabase? = null

        fun getDatabase(context: Context): InventoryDatabase{
            return Instance ?: synchronized(this){
                Room.databaseBuilder(context, InventoryDatabase::class.java, "item_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also {Instance = it}
            }
        }

    }
}