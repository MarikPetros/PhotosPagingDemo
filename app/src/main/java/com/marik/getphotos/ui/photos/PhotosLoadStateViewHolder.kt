package com.marik.getphotos.ui.photos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.marik.getphotos.R

class PhotosLoadStateViewHolder(view: View, retry: () -> Unit) :
    RecyclerView.ViewHolder(view) {
    private val footerLayout: LinearLayout = view.findViewById(R.id.footer_layout)
    private val retryButton: Button = footerLayout.findViewById(R.id.retry_button)
    private val progressBar: ProgressBar = footerLayout.findViewById(R.id.progress_bar)
    private val errorMsg: TextView = footerLayout.findViewById(R.id.error_msg)

    init {
        retryButton.setOnClickListener { retry.invoke() }
    }


    fun bind(loadState: LoadState) {
        if (loadState is LoadState.Error) {
            errorMsg.text = loadState.error.localizedMessage
        }
        progressBar.isVisible = loadState is LoadState.Loading
        retryButton.isVisible = loadState !is LoadState.Loading
        errorMsg.isVisible = loadState !is LoadState.Loading
    }

    companion object {
        fun create(parent: ViewGroup, retry: () -> Unit): PhotosLoadStateViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.photos_load_state_footer_vew_item, parent, false)
            return PhotosLoadStateViewHolder(view, retry)
        }
    }
}