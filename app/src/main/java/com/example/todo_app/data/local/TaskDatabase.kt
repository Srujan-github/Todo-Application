package com.example.todo_app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [LocalTask::class], version = 1, exportSchema = false)
abstract class TaskDatabase :RoomDatabase() {
    abstract fun dao():TaskDao
}