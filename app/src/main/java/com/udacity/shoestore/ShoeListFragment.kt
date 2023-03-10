package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeItemBinding
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.viewmodels.ShoeViewModel
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController

class ShoeListFragment : Fragment() {
    private lateinit var binding: FragmentShoeListBinding
    private lateinit var viewModel: ShoeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_list,
            container,
            false)
        viewModel = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)
        setHasOptionsMenu(true)

        viewModel.shoesList.observe(viewLifecycleOwner, Observer { shoesList ->
            for (shoe in shoesList) {
                val itemBinding = FragmentShoeItemBinding.inflate(inflater)
                itemBinding.shoe = shoe
                binding.linearLayout.addView(itemBinding.root)
            }
        })

        binding.addShoeButton.setOnClickListener { v: View ->
            v.findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetail())
        }

        // https://stackoverflow.com/a/60597473
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Shoe List"

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())
        return true
    }

}