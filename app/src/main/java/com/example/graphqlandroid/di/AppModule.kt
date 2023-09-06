package com.example.graphqlandroid.di

import com.apollographql.apollo3.ApolloClient
import com.example.graphqlandroid.data.ApolloCountryClient
import com.example.graphqlandroid.domain.CountryClient
import com.example.graphqlandroid.domain.usecases.GetCountries
import com.example.graphqlandroid.domain.usecases.GetCountry
import com.example.graphqlandroid.domain.usecases.UseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient {
        return ApolloClient.Builder()
            .serverUrl("https://countries.trevorblades.com/graphql")
            .build()
    }

    @Provides
    @Singleton
    fun provideCountryClient(apolloCountryClient: ApolloCountryClient): CountryClient {
        return apolloCountryClient
    }

    @Provides
    @Singleton
    fun provideGetCountriesUseCase(countryClient: CountryClient): UseCases {
        return UseCases(
            getCountries = GetCountries(countryClient),
            getCountry = GetCountry(countryClient)
        )
    }
}