package com.example.postapp.presentation.screens

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.postapp.data.api.model.PostResponse
import com.example.postapp.domain.usescases.usescases.PostUsesCases
import com.example.postapp.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val postUsesCases: PostUsesCases
): ViewModel() {
    private val _allPostsResponse = MutableLiveData<NetworkResult<List<PostResponse>>>()
    val allPostResponse: LiveData<NetworkResult<List<PostResponse>>>
        get() = _allPostsResponse

    init {
        getAllPosts()
    }

    private fun getAllPosts() {
        viewModelScope.launch {
            postUsesCases.getAllPostsUseCases.invoke().let {
                _allPostsResponse.value = it
            }
        }
    }

    fun postPosts() {
        viewModelScope.launch {
            postUsesCases.postsUseCases.invoke(body = PostResponse(title = "Test title", body = "Test body"))
        }
    }

    fun putPost() {
        viewModelScope.launch {
            postUsesCases.putPostUseCase.invoke(id = "1", body = PostResponse(title = "Test title", body = "Test body")).let {
                Log.d("checkData", "data: ${it.data}")
            }
        }
    }

    fun patchPost() {
        viewModelScope.launch {
            postUsesCases.patchPostUseCase.invoke(id = "1", body = PostResponse(title = "Test title", body = "Test body")).let {
                Log.d("checkData", "data: ${it.data}")
            }
        }
    }

    fun deletePost() {
        viewModelScope.launch {
            postUsesCases.deletePostUseCase.invoke(id = "1").let {
                Log.d("checkData", "data: ${it.data}")
            }
        }
    }
}