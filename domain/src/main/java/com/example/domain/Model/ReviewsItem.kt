package com.example.domain.Model

import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class ReviewsItem(

	val date: String? = null,

	val reviewerName: String? = null,

	val reviewerEmail: String? = null,

	val rating: Int? = null,

	val comment: String? = null
) : Parcelable