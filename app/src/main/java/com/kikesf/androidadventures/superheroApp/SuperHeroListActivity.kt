package com.kikesf.androidadventures.superheroApp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.kikesf.androidadventures.R
import com.kikesf.androidadventures.databinding.ActivitySuperHeroListBinding
import com.kikesf.androidadventures.superheroApp.data.RetrofitService
import com.kikesf.androidadventures.superheroApp.data.model.SuperHeroResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class SuperHeroListActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySuperHeroListBinding
    private lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySuperHeroListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        retrofit = getRetrofit()
        initUI()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun initUI() {
        binding.svSearchHeroe.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchBySuperHeroName(query.orEmpty())
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean = false
        })
    }

    private fun searchBySuperHeroName(query: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val response: Response<SuperHeroResponse> =
                retrofit.create(RetrofitService::class.java).getCharacters(
                    query,
                    "1",
                    "1342ee46b3a8207e80b268dc4b8f97a1",
                    "e7538208ae63bf14cfdf1c6e4ecded44"
                )

            if (response.isSuccessful) {
                Log.i("kikedev", "success :)")
                val data: SuperHeroResponse? = response.body()

                if (data != null) {
                    Log.i("kikedev", data.toString())
                }
            } else {
                Log.i("kikedev", "error :(")
            }
        }
        // IO -> Hilo secundario para peticiones http
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://gateway.marvel.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

// public key = 1342ee46b3a8207e80b268dc4b8f97a1 <- use
// private key = e591b2d38c75b736f8441d4577ae5fc8706ce7e9
// hash = e7538208ae63bf14cfdf1c6e4ecded44
// base url = https://gateway.marvel.com/v1/public/
// https://gateway.marvel.com/v1/public/comics?ts=1&apikey=1342ee46b3a8207e80b268dc4b8f97a1&hash=e7538208ae63bf14cfdf1c6e4ecded44
// comics = GET http://gateway.marvel.com/v1/public/comics?apikey=yourAPIKEY