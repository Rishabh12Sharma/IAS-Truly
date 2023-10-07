package com.example.iastruly

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(val context :Context,var list:ArrayList<Chapters>):RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    class ViewHolder(ItemView:View):RecyclerView.ViewHolder(ItemView) {
        var txtchapter:TextView=ItemView.findViewById(R.id.txt_chapter)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.list_items,parent,false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) {
        var obj =list[position]

        holder.txtchapter.text=obj.chapterNumber


    }
    override fun getItemCount(): Int {
        return list.size
    }
    fun updateData(newChapterInfoList: List<Chapters>) {
        list.clear()
        list.addAll(newChapterInfoList)
        notifyDataSetChanged() // Notify RecyclerView to refresh the data
    }
}