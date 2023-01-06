package com.udacity.shoestore.models

import android.os.Parcelable
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(
    private var _name: String, var _size: Double, private var _company: String, private var _description: String,
    val images: List<String> = mutableListOf()
) : Parcelable, BaseObservable() {
    // To resolve issues with the Double value for size, I found this article
    // https://medium.com/@jencisov/androids-data-binding-s-baseobservable-class-and-bindable-annotation-in-kotlin-1a5c6682a3c1

    var name: String
        @Bindable get() = _name
        set(value) {
            _name = value
        }
    var size: String
        @Bindable get() = _size.toString()
        set(value) {
            _size = value.toDouble()
        }
    var company: String
        @Bindable get() = _company
        set(value) {
            _company = value
        }
    var description: String
        @Bindable get() = _description
        set(value) {
            _description = value
        }
}

