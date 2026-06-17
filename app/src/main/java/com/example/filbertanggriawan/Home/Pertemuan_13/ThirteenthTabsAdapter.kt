package com.example.filbertanggriawan.Home.Pertemuan_13

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.filbertanggriawan.Home.Pertemuan_10.TabAFragment
import com.example.filbertanggriawan.Home.Pertemuan_10.TabBFragment
import com.example.filbertanggriawan.Home.Pertemuan_10.TabCFragment

class ThirteenthTabsAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    // Jumlah total tab yang ada
    override fun getItemCount(): Int = 3 // Untuk Set jumlah tab kita

    // Menentukan Fragment mana yang akan ditampilkan berdasarkan posisi tab
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TabCaptureFragment() // tab 0 / pertama adalah Tab A
            1 -> TabQrcodeFragment() // tab 1 / kedua adalah Tab B
            2 -> TabScanFragment() // tab 2 / ketiga adalah Tab C

            // KENAPA enggak otomatis saja? karena itu terlalu panjang..

            else -> throw IllegalStateException("Posisi tidak valid")
        }
    }
}