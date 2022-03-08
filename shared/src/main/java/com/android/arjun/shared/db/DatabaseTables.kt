package com.android.arjun.shared.db

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "cart")
data class CartItem(
    @PrimaryKey val movie_id: String,
    val title: String,
    val release_year: String,
    val phase: String,
    val running_time: String,
    val budget: String,
    val disc_format_name: String?,
) : Parcelable