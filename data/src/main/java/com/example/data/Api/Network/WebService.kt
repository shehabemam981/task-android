package com.example.data.Api.Network

import com.example.data.Api.model.Products
import com.example.data.Api.model.ProductsItemDto
import retrofit2.http.GET

interface WebService {
    @GET("/products")
    suspend fun GetProducts():Products<List<ProductsItemDto>?>
}