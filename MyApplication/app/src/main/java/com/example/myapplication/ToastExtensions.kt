package com.example.myapplication

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

fun Context.toast(@StringRes resId: Int) =
    Toast.makeText(this,resId,Toast.LENGTH_SHORT).show()

fun Fragment.toast(@StringRes resId : Int) =
    requireContext().toast(resId)