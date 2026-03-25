package com.sofia.campusinfo.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.sofia.campusinfo.viewmodel.SharedViewModel
import com.sofia.campusinfo.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentProfileBinding.inflate(inflater, container, false)

        binding.tvName.text = "Sofia Melati Bareut Runa"
        binding.tvNim.text = "105222005"
        binding.tvName.text = sharedViewModel.username

        val prefs = requireContext().getSharedPreferences("user", 0)

        val savedName = prefs.getString("name", "Soranna")
        binding.tvName.text = savedName

        binding.btnSave.setOnClickListener {
            val newName = binding.etName.text.toString()

            prefs.edit().putString("name", newName).apply()

            binding.tvName.text = newName
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}