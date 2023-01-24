package com.example.whitelabel.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.whitelabel.databinding.FragmentBlank1Binding


class BlankFragment1 : Fragment() {

    private var _binding: FragmentBlank1Binding? = null
    private val binding get() = _binding!!

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBlank1Binding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnFragmentBlank1.setOnClickListener {
            val direction = BlankFragment1Directions.actionBlankFragment1ToBlankFragment3()
            findNavController().navigate(direction)
        }
    }
}