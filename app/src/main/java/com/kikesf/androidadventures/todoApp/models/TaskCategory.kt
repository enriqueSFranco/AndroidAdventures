package com.kikesf.androidadventures.todoApp.models

sealed class TaskCategory() {
    data object PERSONAL: TaskCategory()
    data object BUSINESS: TaskCategory()
    data object OTHER: TaskCategory()
}