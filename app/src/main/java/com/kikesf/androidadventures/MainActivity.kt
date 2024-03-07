package com.kikesf.androidadventures

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.kikesf.androidadventures.imcApp.IMCActivity
import com.kikesf.androidadventures.superheroApp.SuperHeroListActivity
import com.kikesf.androidadventures.todoApp.TaskActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btnIMCApp: Button
    private lateinit var btnTodoApp: Button
    private lateinit var btnSuperheroeApp: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
        initListener()
    }

    private fun initComponents(): Unit {
        btnIMCApp = findViewById(R.id.app_body_mass_check)
        btnTodoApp = findViewById(R.id.btn_todo)
        btnSuperheroeApp = findViewById(R.id.btn_super_heroe_app)
    }

    private fun initListener(): Unit {
        btnIMCApp.setOnClickListener { navigateToActivity(IMCActivity::class.java) }
        btnTodoApp.setOnClickListener { navigateToActivity(TaskActivity::class.java)}
        btnSuperheroeApp.setOnClickListener { navigateToActivity(SuperHeroListActivity::class.java) }
    }

    private fun navigateToActivity(activityClass: Class<*>): Unit {
        val intent = Intent(this, activityClass)
        startActivity(intent)
    }
}
