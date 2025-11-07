package com.example.smarttasks.data.model

data class Task(
    val id: Int,
    val title: String,
    val description: String,
    val status: String,
    val date: String,
    val category: String,
    val priority: String
)
