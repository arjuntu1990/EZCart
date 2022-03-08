package com.android.arjun.shared.data

import com.android.arjun.shared.db.CartItem

data class LoginResp(val status:String, val msg:String)

data class CartResp(val status:String, val cart:List<CartItem>)