package com.android.arjun.ezcartapp.ui.home.details

import androidx.lifecycle.ViewModel
import com.android.arjun.shared.db.CartItem
import javax.inject.Inject

class DetailsViewModel @Inject constructor(): ViewModel() {
    lateinit var cartItem: CartItem
}