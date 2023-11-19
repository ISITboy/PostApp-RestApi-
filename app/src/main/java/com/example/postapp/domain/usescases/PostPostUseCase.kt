package com.example.postapp.domain.usescases

import com.example.postapp.data.api.model.PostResponse
import com.example.postapp.data.repository.PostRepository
import javax.inject.Inject

class PostPostUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    suspend fun invoke(body: PostResponse) = postRepository.postPost(body = body)
}