package com.kobeza.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kobeza.domain.data.entity.SearchEntity
import com.kobeza.search.databinding.ItemSearchBinding

class SearchHolder
private constructor(
    private val binding: ItemSearchBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(data: SearchEntity) {
        binding.data = data
    }

    companion object {
        fun create(
            parent: ViewGroup
        ): SearchHolder {
            return LayoutInflater.from(parent.context).let {
                ItemSearchBinding.inflate(it, parent, false)
            }.let {
                SearchHolder(it)
            }
        }
    }
}