package com.example.graphqlandroid.presentation

import androidx.core.content.contentValuesOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.graphqlandroid.domain.usecases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountriesViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {
    private val _state = MutableStateFlow(
        CountriesState(
            isLoading = true
        )
    )
    val state = _state.asStateFlow()

    init {
        intent {
            _state.update {
                it.copy(
                    countries = useCases.getCountries.execute(),
                    isLoading = false
                )
            }
        }
    }

    fun selectCountry(code: String) = intent {
        _state.update {
            it.copy(
                selectedCountry = useCases.getCountry.execute(code)
            )
        }
    }

    fun dismissCountryDialog() {
        _state.update {
            it.copy(
                selectedCountry = null
            )
        }
    }

    private fun intent(transform: suspend () -> Unit) {
        viewModelScope.launch {
            transform()
        }
    }

}
