package com.kikesf.androidadventures.todoApp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kikesf.androidadventures.R
import com.kikesf.androidadventures.todoApp.models.TaskCategory

class TaskCategoryAdapter(private val categories: List<TaskCategory>, private val onSelectedCategory: (Int) -> Unit) :
    RecyclerView.Adapter<TaskCategoryViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TaskCategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_todo_category, parent, false)
        return TaskCategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskCategoryViewHolder, position: Int) {
        holder.render(categories[position], onSelectedCategory)
    }

    override fun getItemCount(): Int = categories.size

}