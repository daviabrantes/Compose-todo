package com.example.composetodo.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.composetodo.util.Constants.DATABASE_TABLE

@Entity(tableName = DATABASE_TABLE)
data class ToDoTask(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val priority: Priority = Priority.NONE,
)
