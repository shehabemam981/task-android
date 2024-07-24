package com.example.data.ContractDataSource

import com.example.domain.Model.ProductsItem

interface DataSource {
    suspend fun getProductDataSource():List<ProductsItem>?
}