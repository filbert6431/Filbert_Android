package com.example.filbertanggriawan.Pertemuan_7

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.filbertanggriawan.R
import com.example.filbertanggriawan.databinding.ActivitySeventhBinding

class SeventhActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySeventhBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySeventhBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setSupportActionBar(binding.toolbar2)
        supportActionBar?.apply {
            title = "Halaman Seventh"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        // Menampilkan fragment pertama secara default
        replaceFragment(SatuFragment())

        // Setup event click untuk mengganti fragment
        binding.btnFragment1.setOnClickListener {
            replaceFragment(SatuFragment())
        }

        binding.btnFragment2.setOnClickListener {
            replaceFragment(DuaFragment())
        }

        binding.btnFragment3.setOnClickListener {
            replaceFragment(TigaFragment())
        }
    }

    // saat import pilih fragment yang tidak bergaris

    // fungsi dibawah inilah yang digunakan untuk menggnti Fragment

    // Support Fragment - > library Fragment.. sehingga kita bisa gunakan
    // .replace, addtoBackStack, .commit, dll

    // disini kita mereplace Fragment yang berada dlam FragmenContainer ( yang ada di xml kita )
    // coba klik aja
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)
            .addToBackStack(null)
            .commit()
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }

            R.id.action_search -> {
                com.google.android.material.snackbar.Snackbar
                    .make(binding.root, "Search Clicked 🔍", com.google.android.material.snackbar.Snackbar.LENGTH_SHORT)
                    .show()
                true
            }
            R.id.action_settings -> {
                com.google.android.material.snackbar.Snackbar
                    .make(binding.root, "Search Clicked 🔍", com.google.android.material.snackbar.Snackbar.LENGTH_SHORT)
                    .show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

}