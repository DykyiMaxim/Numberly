package com.wm.numberly.di

import com.wm.numberly.data.repositry.NumbersRepositoryImpl
import com.wm.numberly.domain.repository.NumbersRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindNumRepository(
        NumbersRepositoryImpl: NumbersRepositoryImpl
    ): NumbersRepository
}
