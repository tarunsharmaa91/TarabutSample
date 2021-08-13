package com.app.blog.ui.component.post_list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

import com.app.tarabutsample.databinding.ViewItemBinding
import com.app.tarabutsample.model.GamesItem


class GamesListAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<GamesItem, GamesListAdapter.ListViewHolder>(DiffCallback) {

    class ListViewHolder(private var binding: ViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(games: GamesItem) {
            binding.listing = games
            // This is important, because it forces the data binding to execute immediately,
            // which allows the RecyclerView to make the correct view size measurements
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<GamesItem>() {
        override fun areItemsTheSame(oldItem: GamesItem, newItem: GamesItem): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: GamesItem, newItem: GamesItem): Boolean {
            return oldItem.score == newItem.score
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(ViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val results = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(results)
        }
        holder.bind(results)
    }

    class OnClickListener(val clickListener: (results: GamesItem) -> Unit) {
        fun onClick(results: GamesItem) = clickListener(results)
    }
}