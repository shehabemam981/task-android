package com.example.data.Api.Network

import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    fun ProvideLoggingInterceptor(): HttpLoggingInterceptor {
   val logger = HttpLoggingInterceptor{
       Log.e("logger",it)
   }
     logger.level =    HttpLoggingInterceptor.Level.BODY
        return logger
    }

    @Provides
    fun ProvideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()
    }

    @Provides
    fun ProvideGson(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    fun ProvideRetrofit(
        client: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder().client(client).addConverterFactory(gsonConverterFactory)
            .baseUrl("https://dummyjson.com").build()
    }

    @Provides
    fun ProvideWebService(retrofit: Retrofit): WebService {
        return retrofit.create(WebService::class.java)
    }
}