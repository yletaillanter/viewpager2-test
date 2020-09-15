package com.ylt.viewpager2test

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter : RecyclerView.Adapter<CategoryViewHolder>() {
    var list: List<Category> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(parent)
    }
    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(list[position])
    }
    fun setItem(list: List<Category>) {
        this.list = list
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int = list.size
}