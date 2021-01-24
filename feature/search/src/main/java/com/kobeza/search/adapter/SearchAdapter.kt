package com.kobeza.search.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kobeza.domain.data.entity.SearchEntity

class SearchAdapter  :
    RecyclerView.Adapter<SearchHolder>() {

    private val items = mutableListOf<SearchEntity>()

    fun setData(data: List<SearchEntity>) {
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchHolder {
        return SearchHolder.create(parent)
    }

    override fun onBindViewHolder(holder: SearchHolder, position: Int) {
        items[position].let {
            holder.bind(
                data = it
            )
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}