package com.kikesf.androidadventures.todoApp

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.kikesf.androidadventures.R
import com.kikesf.androidadventures.todoApp.adapters.TaskCategoryAdapter
import com.kikesf.androidadventures.todoApp.models.TaskCategory

class TaskActivity : AppCompatActivity() {
    private var categories = listOf(
        TaskCategory.PERSONAL,
        TaskCategory.BUSINESS,
        TaskCategory.OTHER
    )
    lateinit var rvCategories: RecyclerView
    lateinit var taskCategoryAdapter: TaskCategoryAdapter

    lateinit var rvTask: RecyclerView

    lateinit var btnCreateTodo: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        initComponents()
        initUI()
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_todo)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun initComponents() {
        rvCategories = findViewById(R.id.rv_task_categories)
        rvTask = findViewById(R.id.rv_task)
    }

    private fun initListener() {
    }

    private fun initUI() {
        taskCategoryAdapter = TaskCategoryAdapter(categories)
        rvCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = taskCategoryAdapter
    }

    private fun openDialog() {
        Log.i("listener(click)", "open dialog")
    }
}