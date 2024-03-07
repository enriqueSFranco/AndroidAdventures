package com.kikesf.androidadventures.todoApp.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kikesf.androidadventures.todoApp.models.Task

class TaskAdapter(private val task: List<Task>): RecyclerView.Adapter<TaskViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = task.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}