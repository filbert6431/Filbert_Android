package com.example.filbertanggriawan.Pertemuan_3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.filbertanggriawan.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
         binding = ActivityThirdBinding.inflate(layoutInflater)
         setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Activity Third"
            subtitle = "Ini adalah subtitle"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        //val inputnama : EditText = findViewById<EditText>(R.id.nama)
        // val btnsubmit : Button = findViewById<Button>(R.id.submit)

        binding.submit.setOnClickListener {
            val nama = binding.nama.text
            Log.e("Klik btnSubmit","Tombol berhasil di tekan. Isi dari inputNama = $nama")
            Toast.makeText(this, "Pesan Berhasi Terkirim ke $nama" , Toast.LENGTH_SHORT).show()

            val intent = Intent(this, ThirdResultActivity::class.java)
            startActivity(intent)
            //
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}