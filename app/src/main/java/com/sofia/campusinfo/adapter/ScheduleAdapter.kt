package com.sofia.campusinfo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import com.sofia.campusinfo.databinding.ItemScheduleBinding
import com.sofia.campusinfo.model.Schedule
import com.sofia.campusinfo.R

class ScheduleAdapter(private val list: List<Schedule>) :
    RecyclerView.Adapter<ScheduleAdapter.VH>() {

    inner class VH(val binding: ItemScheduleBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = ItemScheduleBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = list[position]

        holder.binding.tvTitle.text = item.title
        holder.binding.tvDate.text = item.date
        holder.binding.tvCategory.text = item.category

        val color = when (item.category) {
            "Akademik" -> R.color.matcha_dark
            "Administrasi" -> R.color.matcha
            "Libur" -> R.color.strawberry
            "Khusus" -> R.color.strawberry_soft
            else -> R.color.text_dark
        }
        holder.binding.tvCategory.setBackgroundResource(color)
        if (position == 0 || item.day != list[position - 1].day) {
            holder.binding.tvHeader.visibility = View.VISIBLE
            holder.binding.tvHeader.text = "📅 ${item.day}"
        } else {
            holder.binding.tvHeader.visibility = View.GONE
        }
    }

    override fun getItemCount() = list.size
}

