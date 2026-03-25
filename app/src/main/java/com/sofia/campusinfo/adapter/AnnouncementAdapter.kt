
package com.sofia.campusinfo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.*
import com.sofia.campusinfo.databinding.ItemAnnouncementBinding
import com.sofia.campusinfo.model.Announcement
import com.sofia.campusinfo.R
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil

class AnnouncementAdapter(
    private val onClick: (Announcement) -> Unit
) : ListAdapter<Announcement, AnnouncementAdapter.VH>(DIFF) {

    inner class VH(val binding: ItemAnnouncementBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = ItemAnnouncementBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = getItem(position)

        holder.binding.tvTitle.text = item.title
        holder.binding.tvDate.text = item.date
        holder.binding.tvCategory.text = item.category

        val color = when (item.category) {
            "Penting" -> R.color.strawberry
            "Info" -> R.color.matcha
            else -> R.color.matcha_dark
        }

        holder.binding.tvCategory.setBackgroundResource(color)

        holder.itemView.setOnClickListener {
            onClick(item)
        }
    }

    companion object {
        val DIFF = object : DiffUtil.ItemCallback<Announcement>() {
            override fun areItemsTheSame(a: Announcement, b: Announcement) =
                a.id == b.id

            override fun areContentsTheSame(a: Announcement, b: Announcement) =
                a == b
        }
    }
}
