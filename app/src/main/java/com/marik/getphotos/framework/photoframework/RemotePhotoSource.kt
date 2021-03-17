package com.marik.getphotos.framework.photoframework

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.marik.getphotos.core.data.IRemotePhotoSource
import com.marik.getphotos.core.model.Photo
import com.marik.getphotos.utils.AppConstants
import kotlinx.coroutines.flow.Flow

class RemotePhotoSource(private val photoService: PhotoService) : IRemotePhotoSource {
    override fun getPhotos(): Flow<PagingData<Photo>> {
        return Pager(
            config = PagingConfig(
                pageSize = AppConstants.NETWORK_PHOTOS_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { PhotoPagingSource(photoService) }
        ).flow
    }
}