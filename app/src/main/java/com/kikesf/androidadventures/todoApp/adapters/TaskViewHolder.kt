package com.kikesf.androidadventures.todoApp.adapters

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.kikesf.androidadventures.R
import com.kikesf.androidadventures.todoApp.models.Task
import com.kikesf.androidadventures.todoApp.models.TaskCategory

class TaskViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val taskDescription = view.findViewById<TextView>(R.id.tv_task_description)
    private val cardTask = view.findViewById<CardView>(R.id.cv_wrapper_task)
    fun render(task: Task) {
        taskDescription.text = task.descrition
        when(task.category) {
            TaskCategory.PERSONAL -> {
                cardTask.setBackgroundColor(ContextCompat.getColor(cardTask.context, R.color.indigo_400))
            }
            TaskCategory.BUSINESS -> {
                cardTask.setBackgroundColor(ContextCompat.getColor(cardTask.context, R.color.violet_400))
            }
            TaskCategory.OTHER -> {
                cardTask.setBackgroundColor(ContextCompat.getColor(cardTask.context, R.color.fuchsia_400))
            }
        }
    }
}