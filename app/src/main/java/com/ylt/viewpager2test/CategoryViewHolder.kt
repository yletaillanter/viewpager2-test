package com.ylt.viewpager2test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.category_item.view.*

class CategoryViewHolder constructor(itemView: View) :
    RecyclerView.ViewHolder(itemView) {
        constructor(parent: ViewGroup) :
            this(LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false))
        fun bind(category: Category) {

            itemView.categoryName.text = category.name
            itemView.categoryImage.setImageResource(category.imageId)
    }
}