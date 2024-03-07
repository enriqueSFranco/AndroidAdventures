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

    fun render(category: TaskCategory) {
        val categoryInfo = getCatetory(category)

        typeTaskCategory.text = categoryInfo.type
        wrapperTaskCategory.setBackgroundColor(ContextCompat.getColor(wrapperTaskCategory.context, categoryInfo.color))
    }

    private fun getCatetory(category: TaskCategory): CategoryInfo {
        val taskCategory = when(category) {
            TaskCategory.PERSONAL -> CategoryInfo("Personal", R.color.indigo_400)
            TaskCategory.BUSINESS -> CategoryInfo("Business", R.color.violet_400)
            TaskCategory.OTHER -> CategoryInfo("Other", R.color.fuchsia_400)
        }
        return taskCategory
    }
}

data class CategoryInfo(val type: String, @ColorRes val color: Int)