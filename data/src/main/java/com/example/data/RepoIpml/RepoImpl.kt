package com.example.data.RepoIpml

import com.example.data.ContractDataSource.DataSource
import com.example.data.toFlow
import com.example.domain.Model.ProductsItem
import com.example.domain.common.Resources
import com.example.domain.contract.Repo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepoImpl @Inject constructor(private  val dataSource: DataSource):Repo{
    override suspend fun getProduct(): Flow<Resources<List<ProductsItem>>> {
     return  toFlow {
         dataSource.getProductDataSource()!!
     }
    }

}