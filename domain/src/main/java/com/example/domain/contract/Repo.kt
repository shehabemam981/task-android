package com.example.domain.contract

import com.example.domain.Model.ProductsItem
import com.example.domain.common.Resources
import kotlinx.coroutines.flow.Flow

interface Repo {
suspend fun getProduct (): Flow<Resources<List<ProductsItem>>>
}