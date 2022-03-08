package com.android.arjun.ezcartapp.ui.home.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.arjun.ezcartapp.R
import com.android.arjun.ezcartapp.databinding.ItemCartBinding
import com.android.arjun.shared.db.CartItem

class CartRvAdap(private val listener: (CartItem) -> Unit) : ListAdapter<CartItem, CartRvAdap.VH>(CartDiffUtil) {
    class VH(private val binding: ItemCartBinding, listener: (CartItem) -> Unit) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.listener = listener
        }
        fun bind(item: CartItem) {
            binding.item = item
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemCartBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.item_cart, parent, false)), listener)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(getItem(position))
    }

    object CartDiffUtil : DiffUtil.ItemCallback<CartItem>() {
        override fun areItemsTheSame(oldItem: CartItem, newItem: CartItem): Boolean {
            return oldItem.movie_id == newItem.movie_id
        }

        override fun areContentsTheSame(oldItem: CartItem, newItem: CartItem): Boolean {
            return oldItem == newItem
        }
    }
}