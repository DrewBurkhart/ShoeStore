package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentInstructionBinding

class InstructionFragment : Fragment() {
    private lateinit var binding: FragmentInstructionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_instruction,
            container,
            false)

        binding.storeButton.setOnClickListener { v: View ->
            v.findNavController().navigate(InstructionFragmentDirections.actionInstructionFragmentToShoeListFragment())
        }

        // https://stackoverflow.com/a/60597473
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Instructions"

        return binding.root
    }
}