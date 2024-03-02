package com.rbs.newsapp.core.di

import com.rbs.newsapp.core.data.repository.ArticleRepository
import com.rbs.newsapp.core.data.repository.MainRepository
import com.rbs.newsapp.core.data.repository.SearchRepository
import com.rbs.newsapp.core.data.repository.SourceRepository
import com.rbs.newsapp.core.domain.repository.IArticleRepository
import com.rbs.newsapp.core.domain.repository.IMainRepository
import com.rbs.newsapp.core.domain.repository.ISearchRepository
import com.rbs.newsapp.core.domain.repository.ISourceRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun mainRepository(mainRepository: MainRepository): IMainRepository

    @Binds
    abstract fun articleRepository(articleRepository: ArticleRepository): IArticleRepository

    @Binds
    abstract fun sourceRepository(sourceRepository: SourceRepository): ISourceRepository

    @Binds
    abstract fun searchRepository(searchRepository: SearchRepository): ISearchRepository
}