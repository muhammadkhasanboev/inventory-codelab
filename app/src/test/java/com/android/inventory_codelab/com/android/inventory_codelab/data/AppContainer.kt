package com.android.inventory_codelab.com.android.inventory_codelab.data

import android.content.Context
import com.android.inventory_codelab.data.InventoryDatabase
import com.android.inventory_codelab.data.ItemsRepository
import com.android.inventory_codelab.data.OfflineItemsRepository


interface AppContainer{
    val itemsRepository: ItemsRepository
}

class AppDataContainer(private val context: Context): AppContainer{
    override val itemsRepository: ItemsRepository by lazy {
        OfflineItemsRepository(InventoryDatabase.getDatabase(context).itemDao())
    }
}