package com.kikesf.androidadventures.todoApp.adapters

import android.content.res.ColorStateList
import android.graphics.Paint
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.kikesf.androidadventures.R
import com.kikesf.androidadventures.todoApp.models.Task
import com.kikesf.androidadventures.todoApp.models.TaskCategory

class TaskViewHolder(view: View): RecyclerView.ViewHolder(view) {
    // TODAS LAS VISTAS TIENEN EL CONTEXTO DE LA ACTIVIDAD
    private val taskDescription = view.findViewById<TextView>(R.id.tv_task_description)
    private val cardTask = view.findViewById<CardView>(R.id.cv_wrapper_task)
    private val cbTask = view.findViewById<CheckBox>(R.id.cb_task)

    fun render(task: Task) {
        taskDescription.text = task.descrition

        val categoryColor = when(task.category) {
            TaskCategory.PERSONAL -> R.color.indigo_400
            TaskCategory.BUSINESS -> R.color.violet_400
            TaskCategory.OTHER -> R.color.fuchsia_400
        }
        cardTask.setBackgroundColor(ContextCompat.getColor(cardTask.context, categoryColor))
        cbTask.backgroundTintList = ColorStateList.valueOf(
            ContextCompat.getColor(cbTask.context, categoryColor)
        )

        if (task.isComplete) {
            taskDescription.paintFlags = taskDescription.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            taskDescription.paintFlags = taskDescription.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
        cbTask.isChecked = task.isComplete
    }
}