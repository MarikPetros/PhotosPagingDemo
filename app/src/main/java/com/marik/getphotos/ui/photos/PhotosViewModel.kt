package com.marik.getphotos.ui.photos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.marik.getphotos.core.domain.GetPhotos
import com.marik.getphotos.core.model.Photo
import kotlinx.coroutines.flow.Flow

class PhotosViewModel(private val getPhotos: GetPhotos) : ViewModel() {
    private var currentSearchResult: Flow<PagingData<Photo>>? = null

    fun getPhotosPage(): Flow<PagingData<Photo>> {
        val lastResult = currentSearchResult

        val newResult: Flow<PagingData<Photo>> = getPhotos()
            .cachedIn(viewModelScope)
        currentSearchResult = newResult
        return newResult
    }

}