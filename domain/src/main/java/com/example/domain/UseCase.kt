package com.example.domain

import com.example.domain.Model.ProductsItem
import com.example.domain.common.Resources
import com.example.domain.contract.Repo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UseCase @Inject constructor(val repo: Repo) {
    suspend fun Invoke(): Flow<Resources<List<ProductsItem>>> {
        return  repo.getProduct()
    }
}