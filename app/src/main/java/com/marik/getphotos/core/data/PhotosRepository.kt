package com.marik.getphotos.core.data

class PhotosRepository(private val remotePhotoSource: IRemotePhotoSource) {
    fun getPhotos() = remotePhotoSource.getPhotos()
}