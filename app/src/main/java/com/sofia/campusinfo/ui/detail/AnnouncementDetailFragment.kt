package com.sofia.campusinfo.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.sofia.campusinfo.model.Announcement
import com.sofia.campusinfo.databinding.FragmentAnnouncementDetailBinding
import androidx.navigation.fragment.findNavController

class AnnouncementDetailFragment : Fragment() {

    private var _binding: FragmentAnnouncementDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAnnouncementDetailBinding.inflate(inflater, container, false)

        val id = arguments?.getInt("id")

        val data = listOf(
            Announcement(1, "Libur Nasional", "20 Mar 2026", "Penting", "Kampus libur total."),
            Announcement(2, "Kuliah Online", "21 Mar 2026", "Info", "Menggunakan Zoom."),
            Announcement(3, "Beasiswa Dibuka", "22 Mar 2026", "Penting", "Segera daftar."),
            Announcement(4, "Event Kampus", "23 Mar 2026", "Info", "Festival kampus."),
            Announcement(5, "Maintenance Sistem", "24 Mar 2026", "Info", "Server update.")
        )

        val selected = data.find { it.id == id }

        binding.tvTitle.text = selected?.title
        binding.tvDate.text = selected?.date
        binding.tvContent.text = selected?.content

        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}