package com.example.postapp.domain.usescases

import com.example.postapp.data.repository.PostRepository
import okhttp3.ResponseBody
import retrofit2.http.Body
import javax.inject.Inject

class GetAllPostsUseCases @Inject constructor(
    private val postRepository: PostRepository
) {
    suspend fun invoke() = postRepository.getAllPosts()
}