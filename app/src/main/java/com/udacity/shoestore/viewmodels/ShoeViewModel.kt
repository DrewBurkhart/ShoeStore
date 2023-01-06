package com.udacity.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {
    var shoe = Shoe("", 0.0, "", "")

    private val _shoesList = MutableLiveData<MutableList<Shoe>>()
    val shoesList: LiveData<MutableList<Shoe>>
        get() = _shoesList

    fun addShoeToList(newShoe: Shoe) {
        // TODO: Figure out Double for size
        if (_shoesList.value == null) {
            _shoesList.value = mutableListOf(shoe)
        } else {
            _shoesList.value?.add(newShoe)
        }
    }

    fun resetShoe() {
        shoe = Shoe("", 0.0, "", "")
    }

    fun validate(): Boolean {
        return this.shoe.name.isNotEmpty() &&
                this.shoe.size.isFinite() &&
                this.shoe.company.isNotEmpty() &&
                this.shoe.description.isNotEmpty()
    }
}