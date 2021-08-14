package com.app.blog

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.blog.ui.component.post_list.adapter.GamesListAdapter
import com.app.tarabutsample.R
import com.app.tarabutsample.model.GamesItem
import com.app.tarabutsample.ui.main.components.viewmodel.ApiStatus

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<GamesItem>?) {
    val adapter = recyclerView.adapter as GamesListAdapter
    adapter.submitList(data)
}

@BindingAdapter("apiStatus")
fun bindStatus(statusImageView: ImageView, status: ApiStatus?) {
    when (status) {
        ApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        ApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        ApiStatus.COMPLETED -> {
            statusImageView.visibility = View.GONE
        }
    }
}
