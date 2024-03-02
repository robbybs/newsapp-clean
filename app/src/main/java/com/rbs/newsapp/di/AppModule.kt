package com.rbs.newsapp.di

import com.rbs.newsapp.core.domain.interactor.ArticleInteractor
import com.rbs.newsapp.core.domain.interactor.MainInteractor
import com.rbs.newsapp.core.domain.interactor.SearchInteractor
import com.rbs.newsapp.core.domain.interactor.SourceInteractor
import com.rbs.newsapp.core.domain.usecase.ArticleUseCase
import com.rbs.newsapp.core.domain.usecase.MainUseCase
import com.rbs.newsapp.core.domain.usecase.SearchUseCase
import com.rbs.newsapp.core.domain.usecase.SourceUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {

    @Binds
    @ViewModelScoped
    abstract fun mainUseCase(mainInteractor: MainInteractor): MainUseCase

    @Binds
    @ViewModelScoped
    abstract fun articleUseCase(articleInteractor: ArticleInteractor): ArticleUseCase

    @Binds
    @ViewModelScoped
    abstract fun sourceUseCase(sourceInteractor: SourceInteractor): SourceUseCase

    @Binds
    @ViewModelScoped
    abstract fun searchUseCase(searchInteractor: SearchInteractor): SearchUseCase
}