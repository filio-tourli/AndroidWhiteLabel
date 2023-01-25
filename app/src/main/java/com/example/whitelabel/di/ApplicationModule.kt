package com.example.whitelabel.di

import android.app.Application
import androidx.room.Room
import com.example.whitelabel.database.DummyDAO
import com.example.whitelabel.database.DummyDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    @Singleton
    fun provideAppDatabase(application: Application): DummyDatabase {
        return Room.databaseBuilder(
            application.applicationContext,
            DummyDatabase::class.java,
            "dummy_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideDummyDao(dummyDatabase: DummyDatabase): DummyDAO {
        return dummyDatabase.dummyDao()
    }
}