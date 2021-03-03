package com.marik.getphotos.ui.photos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.marik.getphotos.R
import com.marik.getphotos.core.model.Photo

/**
 *  PagingDataAdapter
 */
class PhotosAdapter : PagingDataAdapter<Photo, PhotosAdapter.PhotosViewHolder>(PHOTO_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        return PhotosViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        val item = getItem(position)
        item?.let { holder.bind(it) }
    }

    class PhotosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val image: androidx.appcompat.widget.AppCompatImageView =
            itemView.findViewById(R.id.image_photo)
        private val author: androidx.appcompat.widget.AppCompatTextView =
            itemView.findViewById(R.id.text_author)

        fun bind(item: Photo) {
            Glide.with(image.context)
                .load(item.download_url)
                .centerCrop()
                .into(image)

            author.text = item.author
        }
    }

    companion object {
        private val PHOTO_COMPARATOR = object : DiffUtil.ItemCallback<Photo>() {
            override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean =
                oldItem == newItem
        }
    }
}