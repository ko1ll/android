package com.example.viewpager
import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Android(
    val title: String,
    @DrawableRes val imageAndroid: Int,
    @DrawableRes val poster: Int,
    val s: String,
    val s1: String,
    val s2: String,
) : Parcelable {
    fun getArray(): Array<Any> {
        return arrayOf(title,imageAndroid,poster,s,s1,s2);
    }
}