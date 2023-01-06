package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodels.ShoeViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [ShoeDetail.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeDetail : Fragment() {
    private lateinit var binding: FragmentShoeDetailBinding
    private lateinit var viewModel: ShoeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_detail,
            container,
            false
        )
        viewModel = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.saveButton.setOnClickListener { v: View ->
            // TODO: Save shoe
            if (viewModel.validate()) {
                viewModel.addShoeToList(
                    Shoe(
                        name = viewModel.shoe.name,
                        size = viewModel.shoe.size,
                        company = viewModel.shoe.company,
                        description = viewModel.shoe.description
                    )
                )
                v.findNavController()
                    .navigate(ShoeDetailDirections.actionShoeDetailToShoeListFragment())
            } else {
                Toast.makeText(
                    requireContext(),
                    "Check that all fields have been filled",
                    Toast.LENGTH_LONG
                )
                    .show()
            }
        }

        binding.cancelButton.setOnClickListener { v: View ->
            v.findNavController()
                .navigate(ShoeDetailDirections.actionShoeDetailToShoeListFragment())
        }

        return binding.root
    }
}