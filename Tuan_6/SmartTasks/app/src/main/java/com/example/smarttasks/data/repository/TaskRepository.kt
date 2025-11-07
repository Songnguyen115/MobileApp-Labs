package com.example.smarttasks.data.repository


import com.example.smarttasks.data.model.Task
import com.example.smarttasks.data.network.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TaskRepository {
    private val api = Retrofit.Builder()
        .baseUrl("https://amock.io/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)

    suspend fun getTasks() = api.getTasks()
    suspend fun getTaskDetail(id: Int) = api.getTaskDetail(id)
    suspend fun deleteTask(id: Int) = api.deleteTask(id)
}
