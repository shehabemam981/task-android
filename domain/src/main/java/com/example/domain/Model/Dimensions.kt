package com.example.domain.Model

import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Dimensions(

	val depth: Int? = null,

	val width: Int? = null,

	val height: Int? = null
) : Parcelable