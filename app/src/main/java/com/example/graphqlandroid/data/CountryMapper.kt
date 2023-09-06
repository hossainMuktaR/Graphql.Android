package com.example.graphqlandroid.data

import com.example.graphqlandroid.CountriesQuery
import com.example.graphqlandroid.CountryQuery
import com.example.graphqlandroid.domain.Country
import com.example.graphqlandroid.domain.DetailsCountry

fun CountryQuery.Country.toDetailedCountry(): DetailsCountry {
    return DetailsCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No capital",
        currency = currency ?: "No currency",
        languages = languages.mapNotNull { it.name },
        continent = continent.name
    )
}

fun CountriesQuery.Country.toCountry(): Country {
    return Country(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No capital",
    )
}