package com.example.smarttasks.data.network

import com.example.smarttasks.data.model.Task
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET("researchUTH/tasks")
    suspend fun getTasks(): Response<List<Task>>

    @GET("researchUTH/task/{id}")
    suspend fun getTaskDetail(@Path("id") id: Int): Response<Task>

    @DELETE("researchUTH/task/{id}")
    suspend fun deleteTask(@Path("id") id: Int): Response<Unit>
}
