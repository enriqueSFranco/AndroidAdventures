package com.kikesf.androidadventures.todoApp

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.kikesf.androidadventures.R
import com.kikesf.androidadventures.todoApp.adapters.TaskAdapter
import com.kikesf.androidadventures.todoApp.adapters.TaskCategoryAdapter
import com.kikesf.androidadventures.todoApp.models.Task
import com.kikesf.androidadventures.todoApp.models.TaskCategory
import java.util.UUID

class TaskActivity : AppCompatActivity() {
    private var tasks = mutableListOf(
        Task(UUID.randomUUID().toString(), "Hacer ejercicio 10min", TaskCategory.PERSONAL),
        Task(UUID.randomUUID().toString(), "Leer cap. 10", TaskCategory.PERSONAL),
        Task(UUID.randomUUID().toString(), "Pagar la renta", TaskCategory.OTHER),
        Task(UUID.randomUUID().toString(), "Entrega del proyecto", TaskCategory.BUSINESS),
    )
    private var categories = listOf(
        TaskCategory.PERSONAL,
        TaskCategory.BUSINESS,
        TaskCategory.OTHER
    )
    lateinit var rvCategories: RecyclerView
    lateinit var taskCategoryAdapter: TaskCategoryAdapter

    lateinit var rvTasks: RecyclerView
    lateinit var taskAdapter: TaskAdapter

    lateinit var btnCreateTodo: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        initComponents()
        initUI()
        initListener()
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_todo)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun initComponents() {
        rvCategories = findViewById(R.id.rv_task_categories)
        rvTasks = findViewById(R.id.rv_task)

        btnCreateTodo = findViewById(R.id.fab_create_todo)
    }

    private fun initListener() {
        btnCreateTodo.setOnClickListener { openDialog() }
    }

    private fun initUI() {
        // RECYCLER TASK CATEGORIES
        taskCategoryAdapter = TaskCategoryAdapter(categories)
        rvCategories.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = taskCategoryAdapter

        // RECYCLER TASK
        taskAdapter = TaskAdapter(tasks)
        rvTasks.layoutManager =
            LinearLayoutManager(this) // por default la layout manager es vertical
        rvTasks.adapter = taskAdapter
    }

    private fun openDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.activity_dialog)
        // TODO Recuperar la referencia del Button para agregar la nueva tarea
        val btnAddTask =
            dialog.findViewById<Button>(R.id.btn_add_task) // se pone de esta forma dialog.findViewById<Button>(R.id.btn_add_task) para poder acceder a los elementos que hay dentro del dialog
        // TODO Recuperar la referencia del EditText
        val taskDescription = dialog.findViewById<EditText>(R.id.et_task_description)
        // TODO Recuperar la referencia del RadioGroup
        val rgCategories: RadioGroup = dialog.findViewById(R.id.rg_categories)

        btnAddTask.setOnClickListener {
            val categorySelectedId =
                rgCategories.checkedRadioButtonId // recuperamos el id del radio button seleccionado actualmente
            val categorySelected = rgCategories.findViewById<RadioButton>(categorySelectedId)
            val currentCategorySelected: TaskCategory = when (categorySelected.text) {
                "Personal" -> TaskCategory.PERSONAL
                "Business" -> TaskCategory.BUSINESS
                else -> TaskCategory.OTHER
            }
            val newTask = Task(
                UUID.randomUUID().toString(),
                taskDescription.text.toString(),
                currentCategorySelected
            )
            tasks.add(newTask)
            updateTasksList()
            dialog.hide()
        }

        dialog.show()
    }

    private fun updateTasksList() {
        taskAdapter.notifyDataSetChanged()
    }
}