package ru.artkolest.chucknorrisapp.domain.model

import android.os.Parcel
import android.os.Parcelable

data class Value(
    //val cate:gories: List<String>,
    //val id: Int,
    val joke: String?
): Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(joke)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Value> {
        override fun createFromParcel(parcel: Parcel): Value {
            return Value(parcel)
        }

        override fun newArray(size: Int): Array<Value?> {
            return arrayOfNulls(size)
        }
    }
}