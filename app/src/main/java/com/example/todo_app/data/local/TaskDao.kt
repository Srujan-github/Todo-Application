package com.example.todo_app.data.local

import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

interface TaskDao
{
    fun observeById(taskId: String): Flow<LocalTask>

    fun observeAll(): Flow<List<LocalTask>>


    @Query("SELECT * FROM tasks WHERE id = :taskId")
    suspend fun getById(taskId: String): LocalTask

    @Query("SELECT * FROM tasks")
    suspend fun getAll():List<LocalTask>

    @Upsert
    suspend fun upsert(localTask: LocalTask)

    @Upsert
    suspend fun upsertAll(localTasks: List<LocalTask>)

    @Query("DELETE FROM tasks WHERE id = :taskId")
    suspend fun deleteTaskById(taskId: String)

    @Query("DELETE FROM tasks")
    suspend fun deleteAll()

    @Query("UPDATE tasks SET completed = :completed WHERE id = :taskId")
    suspend fun updateCompleted(taskId: String, completed: Boolean)

    @Query("DELETE FROM tasks WHERE completed = 1")
    suspend fun deleteAllCompleted()


}