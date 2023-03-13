package com.wm.numberly.di

import android.content.Context
import androidx.room.Room
import com.wm.numberly.data.local.FactsDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {
    @Singleton
    @Provides
    fun provideFactsDB(@ApplicationContext context: Context): FactsDB {
        return Room.databaseBuilder(context, FactsDB::class.java, "FactsDB").build()
    }

    @Singleton
    @Provides
    fun providesFactDao(FactDataBase: FactsDB) = FactDataBase.dao
}