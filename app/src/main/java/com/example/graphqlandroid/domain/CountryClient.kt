package com.example.graphqlandroid.domain

interface CountryClient {
    suspend fun getCountries(): List<Country>
    suspend fun getCountry(code: String): DetailsCountry?
}