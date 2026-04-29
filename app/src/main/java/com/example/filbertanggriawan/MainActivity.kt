package com.example.filbertanggriawan

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.filbertanggriawan.Pertemuan_2.SecondActivity
import com.example.filbertanggriawan.Pertemuan_3.ThirdActivity
import com.example.filbertanggriawan.Pertemuan_4.FourthActivity
import com.example.filbertanggriawan.Pertemuan_5.activity_fifth
import com.example.filbertanggriawan.Pertemuan_7.SeventhActivity
import com.example.filbertanggriawan.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
            // comment
        }




        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)

        binding.btnlogout.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin logout?")
                .setPositiveButton("Ya") { dialog, _ ->


                    dialog.dismiss()

                    // hapus tokem / data share preferencefilbert
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()

                    dialog.dismiss()

                    val intent = Intent(this, AuthActivity::class.java)
                    startActivity(intent)
                    finish() // agar saat user logout, dia mematikan halaman setelah login
                    // sehingga saat user masuk ke aplikasinya kembali ia tidak mengarah ke home
                    // tapi ke halaman auth

                }
                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.dismiss()
                    Log.e("Info Dialog","Anda memilih Tidak!")
                }
                .show()


        }

        binding.btnPertemuan2.setOnClickListener {
            intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        binding.btnPertemuan3.setOnClickListener {
            intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }

        binding.btnPertemuan4.setOnClickListener {

            intent.putExtra("name", "Politeknik Caltex Riau")
            intent.putExtra("from", "Rumbai")
            intent.putExtra("age", 25)

            intent = Intent(this, FourthActivity::class.java)
            startActivity(intent)
        }

        binding.btnPertemuan5.setOnClickListener {
            intent = Intent(this, activity_fifth::class.java)
            startActivity(intent)
        }

        binding.btnPertemuan7.setOnClickListener {
            intent = Intent(this, SeventhActivity::class.java)
            startActivity(intent)
        }
    }
}