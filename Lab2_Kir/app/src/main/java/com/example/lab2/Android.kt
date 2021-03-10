package com.example.lab2
import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Android(
    val title: String,
    @DrawableRes val imageAndroid: Int,
    @DrawableRes val poster: Int,
    val desc: String,
    val date: String,
    val url: String
) : Parcelable