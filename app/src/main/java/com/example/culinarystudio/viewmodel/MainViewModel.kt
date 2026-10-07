package com.example.culinarystudio.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.culinarystudio.data.MockRepository
import com.example.culinarystudio.data.Recipe
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class UiState {
    object Loading : UiState()
    data class Success(val recipes: List<Recipe>) : UiState()
    data class Error(val message: String) : UiState()
}

class MainViewModel : ViewModel() {
    
    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()
    val stats = MockRepository.userStats

    init {
        loadRecipes()
    }

    fun loadRecipes() {
        viewModelScope.launch {
            try {
                MockRepository.getRecipes().collect { recipes ->
                    _uiState.value = UiState.Success(recipes)
                }
            } catch (e: Exception) {
                _uiState.value = UiState.Error("Connection Failed")
            }
        }
    }
}
