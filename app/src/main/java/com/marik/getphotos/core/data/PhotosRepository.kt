package com.marik.getphotos.core.data

import com.marik.getphotos.framework.photoframework.RemotePhotoSource

class PhotosRepository(private val remotePhotoSource: RemotePhotoSource) {
    fun getPhotos() = remotePhotoSource.getPhotos()
}