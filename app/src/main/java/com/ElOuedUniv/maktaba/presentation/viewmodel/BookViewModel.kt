package com.ElOuedUniv.maktaba.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ElOuedUniv.maktaba.data.model.Book
import com.ElOuedUniv.maktaba.domain.usecase.GetBooksUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class BookViewModel(
    private val getBooksUseCase: GetBooksUseCase
) : ViewModel() {

    // Private mutable state for internal use
    private val _books = MutableStateFlow<List<Book>>(emptyList())
    
    // Public immutable state for UI observation
    val books: StateFlow<List<Book>> = _books.asStateFlow()

    // Loading state
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    init {
        // Load books when ViewModel is created
        loadBooks()
    }


    private fun loadBooks() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val bookList = getBooksUseCase()
                _books.value = bookList
            } finally {
                _isLoading.value = false
            }
        }
    }



    fun refreshBooks() {
        loadBooks()
    }
}
