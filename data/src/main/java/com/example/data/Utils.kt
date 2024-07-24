package com.example.data

import com.example.data.Api.model.Products
import com.example.domain.common.Exceptions
import com.example.domain.common.NetworkConnectionError
import com.example.domain.common.Resources
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import java.util.concurrent.TimeoutException

suspend fun <T> excuteApi(getData:suspend ()->T):T{
    try{
      val data =    getData.invoke()
        return data
    }catch (ex:HttpException){
        if(ex.code() in 400..600){
            val error =     ex.response()?.errorBody().toString()
            val errorResponse = Gson().fromJson(error,Products::class.java)
            throw ex
        }else{
            throw ex
        }

    }catch (ex:TimeoutException){
        throw NetworkConnectionError(ex)
    }catch (ex:Exceptions){
        throw ex
    }
}
suspend fun <T> toFlow(getData: suspend () -> T): Flow<Resources<T>> {
   return flow {
       emit(Resources.Loading)
      val response =  getData.invoke()
       emit(Resources.Success(response))
   }.flowOn(Dispatchers.IO)
       .catch {
           ex->
           when(ex){
               is NetworkConnectionError ->
                   emit(Resources.NetworkError(ex))
               is Exceptions->
                   emit(Resources.serverErrors(ex))

           }
       }
}