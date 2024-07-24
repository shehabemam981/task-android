package com.example.data.RepoIpml

import com.example.domain.contract.Repo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepoModule {
    @Binds
abstract fun BindRepo(
    repoImpl: RepoImpl
):Repo

}