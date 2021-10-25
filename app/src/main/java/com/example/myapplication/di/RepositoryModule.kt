package com.example.myapplication.di

import com.example.myapplication.repository.impl.AccountRepositoryImpl
import com.example.myapplication.repository.impl.DetailsRepositoryImpl
import com.example.myapplication.repository.impl.HistoryRepositoryImpl
import com.example.myapplication.repository.impl.RepositoryImpl
import com.example.myapplication.repository.repositories.*
import com.example.myapplication.repository.services.ImageService
import com.example.myapplication.repository.services.TmdbService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun provideRepository(service: TmdbService) : Repository {
        return RepositoryImpl(service)
    }

    @Provides
    @Singleton
    fun provideAuthRepository(service: TmdbService) : AuthRepository {
        return RepositoryImpl(service)
    }

    @Provides
    @Singleton
    fun provideListRepository(service: TmdbService) : ListRepository {
        return RepositoryImpl(service)
    }

    @Provides
    @Singleton
    fun provideDetailsRepository(service: TmdbService) : DetailsRepository {
        return DetailsRepositoryImpl(service)
    }

    @Provides
    @Singleton
    fun provideHistoryRepository(service: TmdbService) : HistoryRepository {
        return HistoryRepositoryImpl(service)
    }

    @Provides
    @Singleton
    fun provideAccountRepository(service: ImageService) : AccountRepository {
        return AccountRepositoryImpl(service)
    }
}