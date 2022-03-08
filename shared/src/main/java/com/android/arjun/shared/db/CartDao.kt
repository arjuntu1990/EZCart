package com.android.arjun.shared.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CartDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(items: List<CartItem>) : List<Long>

    @Query("SELECT * FROM cart")
    fun getAll() : LiveData<Array<CartItem>>
}
