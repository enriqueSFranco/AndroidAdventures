package com.kikesf.androidadventures.todoApp.adapters

import android.view.View
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.kikesf.androidadventures.R
import com.kikesf.androidadventures.todoApp.models.TaskCategory

class TaskCategoryViewHolder(view: View): RecyclerView.ViewHolder(view) {
    var typeTaskCategory = view.findViewById<TextView>(R.id.tv_todo_category_type)
    var wrapperTaskCategory: CardView = view.findViewById(R.id.cv_wrapper_task_category)

    fun render(category: TaskCategory, onSelectedCategory: (Int) -> Unit) {
        itemView.setOnClickListener { onSelectedCategory(layoutPosition) }

        val color = if (category.isSelected) {
            R.color.purple_700
        } else {
            R.color.purple_500
        }
        wrapperTaskCategory.setCardBackgroundColor(ContextCompat.getColor(wrapperTaskCategory.context ,color))

        itemView.setOnClickListener { onSelectedCategory(layoutPosition) }

        val categoryInfo = getCatetory(category)

        typeTaskCategory.text = categoryInfo.type
        wrapperTaskCategory.setCardBackgroundColor(ContextCompat.getColor(wrapperTaskCategory.context, color))
    }

    private fun getCatetory(category: TaskCategory): CategoryInfo {
        val taskCategory = when(category) {
            TaskCategory.PERSONAL -> CategoryInfo("Personal")
            TaskCategory.BUSINESS -> CategoryInfo("Business")
            TaskCategory.OTHER -> CategoryInfo("Other")
        }
        return taskCategory
    }
}

data class CategoryInfo(val type: String)