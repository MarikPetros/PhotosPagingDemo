package com.marik.getphotos.framework.photoframework

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.marik.getphotos.core.model.Photo
import com.marik.getphotos.utils.AppConstants
import retrofit2.HttpException
import java.io.IOException

private const val PHOTOS_STARTING_PAGE_INDEX = 1

class PhotoPagingSource(private val photoService: PhotoService) : PagingSource<Int, Photo>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Photo> {
        val position = params.key ?: PHOTOS_STARTING_PAGE_INDEX
        return try {
            val page = photoService.getPhotos(position, params.loadSize)
            val nextKey = if (page.isEmpty()) {
                null
            } else {
                position + (params.loadSize / AppConstants.NETWORK_PHOTOS_PAGE_SIZE)
            }
            LoadResult.Page(
                data = page,
                prevKey = if (position == PHOTOS_STARTING_PAGE_INDEX) null else position - 1,
                nextKey = nextKey
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            Log.e("PagingSource", exception.message())
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Photo>): Int? {
        return 0
    }
}