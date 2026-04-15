package com.example.filbertanggriawan.Pertemuan_5

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.filbertanggriawan.R
import com.example.filbertanggriawan.databinding.ActivityFifthBinding

class activity_fifth : AppCompatActivity() {
    private lateinit var binding: ActivityFifthBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFifthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // untuk toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "activity fifth"
            subtitle = "Ini adalah subtitle"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)

            Log.d("DEBUG", "ActionBar = $supportActionBar")
        }


        binding.btnWebView.setOnClickListener {

            val intent = Intent(this, webViewActivity::class.java)
            intent.putExtra("name", "Filbert Anggriawan")
            startActivity(intent)
        }




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }

            R.id.action_search -> {
                Toast.makeText(this, "Search Clicked", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_settings -> {
                Toast.makeText(this, "Settings Clicked", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }



}

