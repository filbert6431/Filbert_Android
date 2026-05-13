package com.example.filbertanggriawan.More

import android.R.id.title
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.filbertanggriawan.R
import com.example.filbertanggriawan.databinding.FragmentHomeBinding
import com.example.filbertanggriawan.databinding.FragmentMoreBinding

class MoreFragment : Fragment() {
    private var _binding: FragmentMoreBinding? = null
    private val binding get() = _binding!!

    private val dataList = listOf(
        "Kotlin",
        "Java",
        "Python",
        "C++",
        "JavaScript",
        "Dart",
        "Swift",
        "Go",
        "Ruby",
        "R",
        "PHP",
        "C#",
        "TypeScript",
        "Shell",
        "SQL",
        "Perl",
        "Rust",
        "Scala",
        "Haskell",
        "Lua",
        "Erlang",
        "Prolog",
        "Assembly",
        "Objective-C",
        "VBA"
    )

    private val dataListWithDesc = listOf(
        mapOf("title" to "Kotlin", "desc" to "Bahasa untuk Android modern"),
        mapOf("title" to "Java", "desc" to "Bahasa OOP yang populer"),
        mapOf("title" to "Python", "desc" to "Bahasa yang mudah dipahami")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
        /* Definisikan adapter sebagai penghubung dataList dengan layout simple_list_item_1 */

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Home"
        }
        // bisa 2 inputan
        val adapter = SimpleAdapter(
            requireContext(),
            dataListWithDesc,
            android.R.layout.simple_list_item_2,
            arrayOf("title", "desc"),
            intArrayOf(android.R.id.text1, android.R.id.text2)

//            text 1 pasti judul
//            text 2 pasti deskripsi
//
//            sesuai dengan urutan teks kalian
        )

        // cuman bisa 1 inputan

//        val adapter = ArrayAdapter(
//            requireContext(),
//            android.R.layout.simple_list_item_1,
//            dataList
//        )

        // Hubungkan listViewItems dengan adapter
        binding.listViewItems.adapter = adapter

        // Tambahkan aksi saat item di-list diklik
//        binding.listViewItems.setOnItemClickListener { _, _, position, _ ->
//            val selectedItem = dataList[position]
//            Toast.makeText(requireContext(), "Kamu memilih: $selectedItem", Toast.LENGTH_SHORT).show()
//        }

        // Tambahkan aksi saat item di-list diklik
        binding.listViewItems.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = dataListWithDesc[position]
            val title = selectedItem["title"]
            val desc = selectedItem["desc"]
            Toast.makeText(requireContext(), "Kamu memilih: $title ($desc)", Toast.LENGTH_SHORT).show()
        }
    }

}