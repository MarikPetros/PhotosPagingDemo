package com.marik.getphotos.ui.photos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.marik.getphotos.core.domain.GetPhotos
import com.marik.getphotos.core.model.Photo
import kotlinx.coroutines.flow.Flow

class PhotosViewModel(private val getPhotos: GetPhotos) : ViewModel() {
    fun getPhotosPage(): Flow<PagingData<Photo>> {
        return this.getPhotos()
            .cachedIn(viewModelScope)
    }
}