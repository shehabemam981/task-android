package com.example.data.DataSourceImpl

import com.example.data.ContractDataSource.DataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DataSourceModule{
    @Binds
    abstract fun BindDataSource(
        dataSourceProductImpl: DataSourceProductImpl
    ):DataSource
}