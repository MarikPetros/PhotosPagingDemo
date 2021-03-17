package com.marik.getphotos.core.data

import androidx.paging.PagingData
import com.marik.getphotos.core.model.Photo
import kotlinx.coroutines.flow.Flow

interface IRemotePhotoSource {
    fun getPhotos(): Flow<PagingData<Photo>>
}