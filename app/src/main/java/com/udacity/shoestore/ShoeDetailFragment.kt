package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding

/**
 * A simple [Fragment] subclass.
 * Use the [ShoeDetail.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeDetail : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentShoeDetailBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_detail,
            container,
            false)

        binding.saveButton.setOnClickListener { v: View ->
            // TODO: Save shoe
            v.findNavController().navigate(ShoeDetailDirections.actionShoeDetailToShoeListFragment())
        }

        binding.cancelButton.setOnClickListener { v: View ->
            v.findNavController().navigate(ShoeDetailDirections.actionShoeDetailToShoeListFragment())
        }

        return binding.root
    }
}