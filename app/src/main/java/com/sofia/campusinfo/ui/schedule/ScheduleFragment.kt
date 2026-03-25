package com.sofia.campusinfo.ui.schedule

import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import com.sofia.campusinfo.adapter.ScheduleAdapter
import com.sofia.campusinfo.model.Schedule
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.sofia.campusinfo.databinding.FragmentScheduleBinding

class ScheduleFragment : Fragment() {

    private var _binding: FragmentScheduleBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentScheduleBinding.inflate(inflater, container, false)

        val data = listOf(
            Schedule("Pengisian KRS", "12–18 Feb 2026", "Akademik", "Senin"),
            Schedule("Persetujuan KRS", "12–20 Feb 2026", "Akademik", "Senin"),
            Schedule("Pengajuan PRS", "23 Feb – 4 Mar 2026", "Akademik", "Senin"),
            Schedule("Persetujuan PRS" , "23 Feb – 6 Mar 2026", "Akademik", "Senin"),
            Schedule("Perkuliahan Semester Genap" , "23 Feb – 26 Juni 2026", "Akademik", "Senin"),
            Schedule("Pengajuan Cuti Semester", "9 Feb – 17 Apr 2026", "Administrasi", "Senin"),
            Schedule("Kuliah Daring Hari Raya", "16 – 27 Mar 2026", "Khusus", "Senin"),
            Schedule("🌙 Hari Raya Nyepi", "11 Maret 2026", "Libur", "Selasa"),
            Schedule("🕌 Idul Fitri", "20–21 Maret 2026", "Libur","Kamis"),
            Schedule("✝️ Wafat Isa Almasih" , "3 April 2026", "Libur", "Jumat"),
            Schedule("🏭 Hari Buruh", "1 Mei 2026", "Libur","Rabu")
        )

        val adapter = ScheduleAdapter(data)

        binding.rvSchedule.layoutManager = LinearLayoutManager(requireContext())
        binding.rvSchedule.setHasFixedSize(true)
        binding.rvSchedule.adapter = adapter

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}