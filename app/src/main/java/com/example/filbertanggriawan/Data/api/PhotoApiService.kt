package com.example.filbertanggriawan.Data.api

import com.example.filbertanggriawan.Data.model.PhotoModel
import retrofit2.http.GET

interface PhotoApiService {
    // Untuk Request GET ke API List ( yang menjadi Endpoint )
    @GET("list")
    suspend fun getPhotos(): List<PhotoModel>
}