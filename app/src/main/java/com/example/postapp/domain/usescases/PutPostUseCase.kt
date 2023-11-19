package com.example.postapp.domain.usescases

import com.example.postapp.data.api.model.PostResponse
import com.example.postapp.data.repository.PostRepository
import javax.inject.Inject

class PutPostUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    suspend fun invoke(id: String, body: PostResponse) = postRepository.putPost(id = id, body = body)
}