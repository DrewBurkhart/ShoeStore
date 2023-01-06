package com.udacity.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {

    val shoeName = MutableLiveData<String>()
    val shoeCompany = MutableLiveData<String>()
    val shoeSize = MutableLiveData<String>()
    val shoeDescription = MutableLiveData<String>()

    var shoe = Shoe("", 0.0, "", "")

    private val _shoesList = MutableLiveData<MutableList<Shoe>>()
    val shoesList: LiveData<MutableList<Shoe>>
        get() = _shoesList

    fun addShoeToList(newShoe: Shoe) {
        if (_shoesList.value == null) {
            _shoesList.value = mutableListOf(newShoe)
        } else {
            _shoesList.value?.add(newShoe)
        }
    }

    fun resetShoe() {
        shoeName.value = ""
        shoeCompany.value = ""
        shoeSize.value = ""
        shoeDescription.value = ""
    }

    fun validate(): Boolean {
        return this.shoeName.value?.isNotEmpty() == true &&
                this.shoeCompany.value?.isNotEmpty() == true &&
                this.shoeSize.value?.isNotEmpty() == true &&
                this.shoeDescription.value?.isNotEmpty() == true
    }
}