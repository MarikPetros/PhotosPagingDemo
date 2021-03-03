package com.marik.getphotos.framework.photoframework

import com.marik.getphotos.core.model.Photo
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotoService {
    @GET("v2/list")
    suspend fun getPhotos(@Query("page") page: Int, @Query("limit") limit: Int): List<Photo> //
}