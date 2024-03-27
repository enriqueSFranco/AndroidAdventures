package com.kikesf.androidadventures

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.kikesf.androidadventures.databinding.ActivityMainBinding
import com.kikesf.androidadventures.imcApp.IMCActivity
import com.kikesf.androidadventures.superheroApp.SuperHeroListActivity
import com.kikesf.androidadventures.todoApp.TaskActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding // 1

    private lateinit var btnAppIMC: Button
    private lateinit var btnAppTodo: Button
    private lateinit var btnAppSuperheroe: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // 2
        setContentView(binding.root) // 3
        initComponents()
        initListener()
    }

    private fun initComponents(): Unit {
        btnAppIMC = findViewById(R.id.btn_app_body_mass_check)
        btnAppTodo = findViewById(R.id.btn_app_todo)
        btnAppSuperheroe = findViewById(R.id.btn_app_super_heroe)
    }

    private fun initListener(): Unit {
        btnAppIMC.setOnClickListener { navigateToActivity(IMCActivity::class.java) }
        btnAppTodo.setOnClickListener { navigateToActivity(TaskActivity::class.java)}
        btnAppSuperheroe.setOnClickListener { navigateToActivity(SuperHeroListActivity::class.java) }
    }

    private fun navigateToActivity(activityClass: Class<*>): Unit {
        val intent = Intent(this, activityClass)
        startActivity(intent)
    }
}
