package com.devoma.islamiapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Chapter(
    val INDEX : Int,
    val nameEN : String,
    val nameAr : String,
    val ayaytNumber : String,
) : Parcelable