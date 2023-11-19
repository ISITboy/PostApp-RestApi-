package com.example.postapp.data.repository

import com.example.postapp.data.api.RemoteDataSource
import com.example.postapp.data.api.model.PostResponse
import com.example.postapp.utils.BaseApiResponse
import com.example.postapp.utils.NetworkResult
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
):BaseApiResponse(){
    suspend fun getAllPosts(): NetworkResult<List<PostResponse>> {
        return safeApiCall { remoteDataSource.getAllPosts() }
    }

    suspend fun postPost(body: PostResponse): NetworkResult<PostResponse> {
        return safeApiCall { remoteDataSource.postPosts(body = body) }
    }

    suspend fun putPost(id: String, body: PostResponse): NetworkResult<PostResponse> {
        return safeApiCall { remoteDataSource.putPosts(id = id, body = body) }
    }

    suspend fun patchPost(id: String, body: PostResponse): NetworkResult<PostResponse> {
        return safeApiCall { remoteDataSource.patchPosts(id = id, body = body) }
    }

    suspend fun deletePost(id: String): NetworkResult<PostResponse> {
        return safeApiCall { remoteDataSource.deletePosts(id = id) }
    }
}