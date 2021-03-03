package com.marik.getphotos.core.domain

import com.marik.getphotos.core.data.PhotosRepository

class GetPhotos(private val photosRepository: PhotosRepository) {
    operator fun invoke() = photosRepository.getPhotos()
}