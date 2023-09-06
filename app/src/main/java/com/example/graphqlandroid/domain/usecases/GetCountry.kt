package com.example.graphqlandroid.domain.usecases

import com.example.graphqlandroid.domain.CountryClient
import com.example.graphqlandroid.domain.DetailsCountry

class GetCountry(
    private val countryClient: CountryClient
) {

    suspend fun execute(code: String): DetailsCountry? {
        return countryClient.getCountry(code)
    }
}