package com.example.postapp.domain.usescases.usescases

import com.example.postapp.domain.usescases.DeletePostUseCase
import com.example.postapp.domain.usescases.GetAllPostsUseCases
import com.example.postapp.domain.usescases.PatchPostUseCase
import com.example.postapp.domain.usescases.PostPostUseCase
import com.example.postapp.domain.usescases.PutPostUseCase
import javax.inject.Inject

class PostUsesCases @Inject constructor(
    val getAllPostsUseCases: GetAllPostsUseCases,
    val postsUseCases: PostPostUseCase,
    val patchPostUseCase: PatchPostUseCase,
    val putPostUseCase: PutPostUseCase,
    val deletePostUseCase: DeletePostUseCase
)