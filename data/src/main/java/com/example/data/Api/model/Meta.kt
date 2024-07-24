package com.example.data.Api.model

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class Meta(

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("qrCode")
	val qrCode: String? = null,

	@field:SerializedName("barcode")
	val barcode: String? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null
) : Parcelable