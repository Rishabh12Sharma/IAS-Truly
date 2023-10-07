package com.example.iastruly

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ChaptersActivity : AppCompatActivity() {

    lateinit var recyclerView:RecyclerView
    lateinit var layoutManager:RecyclerView.LayoutManager
    lateinit var recyclerAdapter: MainAdapter

    lateinit var searchView: SearchView

    val chapterInfoList= arrayListOf(
        Chapters("Chapter 1 : Food:Where Does It Come From?"),
        Chapters("Chapter 2 : Components of Food"),
        Chapters("Chapter 3 : Fibre to Fabric"),
        Chapters("Chapter 4 : Sorting Materials into Groups"),
        Chapters("Chapter 5 : Separation of Substances"),
        Chapters("Chapter 6 : Changes around Us")
    )
    private val filteredChapterInfoList = ArrayList<Chapters>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapters)

        searchView=findViewById(R.id.searchView)

        layoutManager=LinearLayoutManager(this)
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerAdapter=MainAdapter(this,chapterInfoList)
        recyclerView.adapter=recyclerAdapter
        recyclerView.layoutManager=layoutManager


        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterChapters(newText)
                return true
            }
        })


    }
    private fun filterChapters(query: String?) {
        filteredChapterInfoList.clear()

        if (!query.isNullOrBlank()) {
            for (chapter in chapterInfoList) {
                if (chapter.chapterNumber.contains(query, ignoreCase = true)) {
                    filteredChapterInfoList.add(chapter)
                }
            }
        } else {
            filteredChapterInfoList.addAll(chapterInfoList)
        }

        recyclerAdapter.updateData(filteredChapterInfoList)
    }


}