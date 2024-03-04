package com.kikesf.androidadventures

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.kikesf.androidadventures.imcApp.IMCActivity
import com.kikesf.androidadventures.todoApp.TodoActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btnIMCApp: Button
    private lateinit var btnTodoApp: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
        initListener()
    }

    private fun initComponents(): Unit {
        btnIMCApp = findViewById<Button>(R.id.app_body_mass_check)
        btnTodoApp = findViewById<Button>(R.id.btn_todo)
    }

    private fun initListener(): Unit {
        btnIMCApp.setOnClickListener { navigateToActivity(IMCActivity::class.java) }
        btnTodoApp.setOnClickListener { navigateToActivity(TodoActivity::class.java)}
    }

    private fun navigateToActivity(activityClass: Class<*>): Unit {
        val intent = Intent(this, activityClass)
        startActivity(intent)
    }
}
