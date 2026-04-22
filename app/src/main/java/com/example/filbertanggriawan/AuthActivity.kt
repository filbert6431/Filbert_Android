package com.example.filbertanggriawan

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.filbertanggriawan.databinding.ActivityAuthBinding
import com.google.android.material.snackbar.Snackbar

class AuthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)

        //Kondisi jika isLogin bernilai true

        // kunci kodenya adalah kode dibawah ini
        val isLogin = sharedPref.getBoolean("isLogin", false)
        if (isLogin) {
            intent = Intent (this, MainActivity::class.java)
            startActivity(intent)

        }

        binding.submit.setOnClickListener {

            val username = binding.username.text.toString()
            val password = binding.password.text.toString()



            // decision hanya membaca variabel

            if (username == password) {
                val editor = sharedPref.edit()
                editor.putBoolean("isLogin", true)


                editor.putString("username",username)

                // editor apply untuk mensave data yang dimasukkan kedalam sessio
                editor.apply()

                intent = Intent (this, MainActivity::class.java)
                startActivity(intent)
                finish()
                // artinya halaman tersebut tidak akan dipakai lagi
            // agar saat user tekan back, dia tidak kenbali ke halaman auth tetapi keluar halaman

            }
            else {
                Snackbar.make(binding.root, "Silahkan coba lagi", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Tutup"){
                        Log.e("Info Snackbar","user gagal login")
                    }
                    .show()

            }
        }


    }
}