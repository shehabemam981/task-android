package com.example.data.DataSourceImpl

import com.example.data.Api.Network.WebService
import com.example.data.ContractDataSource.DataSource
import com.example.data.excuteApi
import com.example.domain.Model.ProductsItem
import javax.inject.Inject

class DataSourceProductImpl @Inject constructor(private val webService: WebService):DataSource {
    override suspend fun getProductDataSource(): List<ProductsItem> {
val response =    excuteApi {
           webService.GetProducts()
       }
      return  response.products!!.filterNotNull().map {
          it.toProductsItem()
      }
    }
}