package com.kikesf.androidadventures.superheroApp

import android.os.Bundle
import android.widget.SearchView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.kikesf.androidadventures.R
import com.kikesf.androidadventures.databinding.ActivitySuperHeroListBinding

class SuperHeroListActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuperHeroListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySuperHeroListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initUI()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun initUI() {

    }

    private fun searchBySuperHeroName(query: String) {}
}

// public key = 1342ee46b3a8207e80b268dc4b8f97a1 <- use
// private key = e591b2d38c75b736f8441d4577ae5fc8706ce7e9

// comics = GET http://gateway.marvel.com/v1/public/comics?apikey=yourAPIKEY