package com.example.graphqlandroid.domain.usecases

import com.example.graphqlandroid.domain.Country
import com.example.graphqlandroid.domain.CountryClient

class GetCountries(
    private val countryClient: CountryClient
) {

    suspend fun execute(): List<Country> {
        return countryClient
            .getCountries()
            .sortedBy { it.name }
    }
}