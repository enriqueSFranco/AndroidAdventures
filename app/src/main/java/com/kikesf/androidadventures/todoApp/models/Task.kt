package com.kikesf.androidadventures.todoApp.models

data class Task(val id: String, val descrition: String, val category: TaskCategory, val isComplete: Boolean = false)
