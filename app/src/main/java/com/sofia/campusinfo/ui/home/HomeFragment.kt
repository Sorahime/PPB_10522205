package com.sofia.campusinfo.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.fragment.app.viewModels
import android.widget.ArrayAdapter
import android.widget.AdapterView
import com.sofia.campusinfo.viewmodel.HomeViewModel
import com.sofia.campusinfo.viewmodel.SharedViewModel
import com.sofia.campusinfo.adapter.AnnouncementAdapter
import com.sofia.campusinfo.model.Announcement
import com.sofia.campusinfo.R
import com.sofia.campusinfo.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        val adapter = AnnouncementAdapter {

            val bundle = Bundle()
            bundle.putInt("id", it.id)

            findNavController().navigate(R.id.action_home_to_detail, bundle)
        }

        binding.rvAnnouncement.layoutManager = LinearLayoutManager(requireContext())
        binding.rvAnnouncement.setHasFixedSize(true)
        binding.rvAnnouncement.adapter = adapter
        sharedViewModel.username = "Sofia"

        adapter.submitList(viewModel.announcements)

        val categories = listOf("Semua", "Penting", "Info")

        val spinnerAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_dropdown_item,
            categories
        )

        binding.spFilter.adapter = spinnerAdapter

        binding.spFilter.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                    val selected = categories[position]
                    val filtered = if (selected == "Semua") {
                        viewModel.announcements
                    } else {
                        viewModel.announcements.filter {
                            it.category == selected
                        }
                    }
                    adapter.submitList(filtered)
                }
                override fun onNothingSelected(parent: AdapterView<*>) {}
            }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}