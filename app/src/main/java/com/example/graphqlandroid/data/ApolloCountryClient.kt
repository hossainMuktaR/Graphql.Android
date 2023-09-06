package com.example.graphqlandroid.data

import com.apollographql.apollo3.ApolloClient
import com.example.graphqlandroid.CountriesQuery
import com.example.graphqlandroid.CountryQuery
import com.example.graphqlandroid.domain.Country
import com.example.graphqlandroid.domain.CountryClient
import com.example.graphqlandroid.domain.DetailsCountry
import javax.inject.Inject

class ApolloCountryClient @Inject constructor(
    private val apolloClient: ApolloClient
) : CountryClient {
    override suspend fun getCountries(): List<Country> {
        return apolloClient
            .query(CountriesQuery())
            .execute()
            .data?.countries?.map { it.toCountry() } ?: emptyList()
    }

    override suspend fun getCountry(code: String): DetailsCountry? {
       return apolloClient.query(CountryQuery(code)).execute()
           .data?.country?.toDetailedCountry()
    }

}