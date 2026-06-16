package com.example.filbertanggriawan.Note

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.filbertanggriawan.Data.AppDatabase
import com.example.filbertanggriawan.Data.entity.NoteEntity
import com.example.filbertanggriawan.databinding.FragmentNoteBinding
import kotlinx.coroutines.launch


class NoteFragment : Fragment() {
    private lateinit var adapter: NoteAdapter
    private lateinit var db: AppDatabase
    private val notes = mutableListOf<NoteEntity>()



    private var _binding: FragmentNoteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        db = AppDatabase.getInstance(requireContext())
        //adapter = NoteAdapter(notes)
        adapter = NoteAdapter(notes, this) // --> tambah parameter this

        binding.rvNotes.layoutManager = LinearLayoutManager(requireContext())
        binding.rvNotes.adapter = adapter

        /** Tambah ini sebagai garis pemisah **/
        val dividerItemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        binding.rvNotes.addItemDecoration(dividerItemDecoration)

        fetchNotes()


        binding.fabAddNote.setOnClickListener {
            startActivity(Intent(requireContext(), NoteFormActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        fetchNotes()
    }

    private fun fetchNotes() {
        lifecycleScope.launch {
            val data = db.noteDao().getAll() //pemanggilan query
            notes.clear()
            notes.addAll(data)
            adapter.notifyDataSetChanged()
        }
    }
    fun deleteNote(note: NoteEntity) {
        lifecycleScope.launch {
            db.noteDao().delete(note) //Hapus Note
            fetchNotes()              //Fetch lagi data notes terbaru
        }

    }
    }