package com.zuyatna.listmaker.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zuyatna.listmaker.databinding.ListItemViewHolderBinding
import com.zuyatna.listmaker.models.TaskList

class ListItemsRecyclerViewAdapter(
    private var list: TaskList
) : RecyclerView.Adapter<ListItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        val binding = ListItemViewHolderBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return ListItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return list.tasks.size
    }
}