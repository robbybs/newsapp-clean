package com.rbs.newsapp.core.presentation.ui.source_screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rbs.newsapp.core.data.remote.model.Sources
import com.rbs.newsapp.databinding.SourceItemBinding

class SourceAdapter : ListAdapter<Sources, SourceAdapter.MyViewHolder>(DIFF_CALLBACK) {
    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            SourceItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = getItem(position)
        if (data != null) {
            holder.bind(data)
        }
    }

    inner class MyViewHolder(private val binding: SourceItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Sources) {
            with(binding) {
                tvName.text = data.name
                tvDescription.text = data.description
                tvUrl.text = data.url
                tvCategory.text = data.category

                val sourcesId = data.id
                cvSource.setOnClickListener { onItemClickCallback?.onItemClicked(sourcesId) }
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: String)
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Sources>() {
            override fun areItemsTheSame(oldItem: Sources, newItem: Sources): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Sources, newItem: Sources): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}