package com.example.basictestapp.di

import android.content.Context
import com.example.basictestapp.data.repository.NewsRepositoryImpl
import com.example.basictestapp.data.repository.PetsRepositoryImpl
import com.example.basictestapp.data.service.NewsService
import com.example.basictestapp.domain.repository.NewsRepository
import com.example.basictestapp.domain.repository.PetsRepository
import com.example.basictestapp.domain.usecases.news.GetNewsListUseCase
import com.example.basictestapp.domain.usecases.pet.GetIndividualPet
import com.example.basictestapp.domain.usecases.pet.GetPets
import com.example.basictestapp.domain.usecases.pet.PetUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {



    @Provides
    @Singleton
    fun providePetsRepository(): PetsRepository {
        return PetsRepositoryImpl()
    }


    @Provides
    @Singleton
    fun providePetUseCases(@ApplicationContext context: Context, repository: PetsRepository): PetUseCases {
        return PetUseCases(
            getPets = GetPets(context,repository),
            getIndividualItem = GetIndividualPet(repository)
        )
    }

    @Provides
    fun providerNewsService(retrofit: Retrofit): NewsService =
        retrofit.create(NewsService::class.java)

    @Provides
    @Singleton
    fun provideNewsRepository(newsService: NewsService): NewsRepository =
        NewsRepositoryImpl(newsService)


    @Provides
    @Singleton
    fun provideNewListUseCase(repository: NewsRepository): GetNewsListUseCase{
        return GetNewsListUseCase(repository)
    }



}