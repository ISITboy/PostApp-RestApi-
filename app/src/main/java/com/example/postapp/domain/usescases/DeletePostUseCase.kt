package com.example.postapp.domain.usescases

import com.example.postapp.data.repository.PostRepository
import javax.inject.Inject

class DeletePostUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    suspend fun invoke(id: String) = postRepository.deletePost(id = id)
}