package com.example.filbertanggriawan.Pertemuan_5

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.activity.addCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.filbertanggriawan.R
import com.example.filbertanggriawan.databinding.ActivityWebViewBinding

class webViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // untuk toolbar dan agar bisa balik ke halaman kode saat buka web
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Halo, ${intent.getStringExtra("name")}"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        binding.webView.webViewClient = WebViewClient()
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.loadUrl("https://merdeka.com")

        // Agar Toolbar hide/show saat scroll web
        binding.webView.setOnScrollChangeListener { _, _, scrollY, _, oldScrollY ->
            if (scrollY > oldScrollY) {
                binding.appBar.setExpanded(false, true) // sembunyikan
            } else if (scrollY < oldScrollY) {
                binding.appBar.setExpanded(true, true) // tampilkan
            }
        }



        // kode onBackPressed tidak bisa lagi
        // jadi gpt recomend kode yang ini

        onBackPressedDispatcher.addCallback(this) {
            if (binding.webView.canGoBack()) {
                binding.webView.goBack()
            } else {
                finish()
            }
        }

        // WEB VIEW  ^




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


    // untuk web
}