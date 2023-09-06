package com.example.graphqlandroid.presentation

import com.example.graphqlandroid.domain.Country
import com.example.graphqlandroid.domain.DetailsCountry

data class CountriesState(
    val countries: List<Country> = emptyList(),
    val isLoading: Boolean = false,
    val selectedCountry: DetailsCountry? = null
)