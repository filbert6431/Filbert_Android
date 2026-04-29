package com.example.filbertanggriawan.Home

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.filbertanggriawan.AuthActivity
import com.example.filbertanggriawan.Home.Pertemuan_2.SecondActivity
import com.example.filbertanggriawan.Home.Pertemuan_3.ThirdActivity
import com.example.filbertanggriawan.Home.Pertemuan_4.FourthActivity
import com.example.filbertanggriawan.Home.Pertemuan_5.activity_fifth
import com.example.filbertanggriawan.Home.Pertemuan_7.SeventhActivity
import com.example.filbertanggriawan.R
import com.example.filbertanggriawan.databinding.FragmentHomeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false)

        // kita tidak pakai yang versi inflate, tetapi memakan versi yang dibawah

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val sharedPref = requireContext().getSharedPreferences("user_pref", MODE_PRIVATE)

        binding.btnlogout.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin logout?")
                .setPositiveButton("Ya") { dialog, _ ->


                    dialog.dismiss()

                    // hapus tokem / data share preferencefilbert
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()

                    dialog.dismiss()

                    val intent = Intent(requireContext(), AuthActivity::class.java)
                    startActivity(intent)
                    requireActivity().finish() // agar saat user logout, dia mematikan halaman setelah login
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
           val  intent = Intent(requireContext(), SecondActivity::class.java)
            startActivity(intent)
        }

        binding.btnPertemuan3.setOnClickListener {
          val  intent = Intent(requireContext(), ThirdActivity::class.java)
            startActivity(intent)
        }

        binding.btnPertemuan4.setOnClickListener {
            val intent = Intent(requireContext(), FourthActivity::class.java)
            intent.putExtra("name", "Politeknik Caltex Riau")
            intent.putExtra("from", "Rumbai")
            intent.putExtra("age", 25)
            startActivity(intent)
        }

        binding.btnPertemuan5.setOnClickListener {
            val intent = Intent(requireContext(), activity_fifth::class.java)
            startActivity(intent)
        }

        binding.btnPertemuan7.setOnClickListener {
            val intent = Intent(requireContext(), SeventhActivity::class.java)
            startActivity(intent)
        }
    }


}