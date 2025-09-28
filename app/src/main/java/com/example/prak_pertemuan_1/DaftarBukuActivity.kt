package com.example.prak_pertemuan_1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.prak_pertemuan_1.databinding.ActivityDaftarBukuBinding
import com.example.prak_pertemuan_1.ui.adapter.BookAdapter
import com.example.prak_pertemuan_1.viewmodel.MainViewModel
import androidx.activity.viewModels

class DaftarBukuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDaftarBukuBinding
    private val viewModel: MainViewModel by viewModels()
    private val adapter = BookAdapter(books = emptyList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDaftarBukuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        viewModel.books.observe(this) {
            adapter.setData(it)
        }

        viewModel.fetchBooks(query = "kotlin programming")
    }
}