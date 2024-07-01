package com.example.todo_app.domain

import com.example.todo_app.data.local.LocalTask

data class Task(
    val id: String,
    val title: String,
    val description: String,
    val completed: Boolean
)

fun Task.toLocalTask(): LocalTask = LocalTask(
    id = id,
    title = title,
    description = description,
    completed = completed
)