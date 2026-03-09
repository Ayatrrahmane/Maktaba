package com.ElOuedUniv.maktaba.domain.usecase

import com.ElOuedUniv.maktaba.data.model.Book
import com.ElOuedUniv.maktaba.data.repository.BookRepository


class GetBooksUseCase(
    private val bookRepository: BookRepository
) {
    class SearchBooksUseCase(
        private val repository: BookRepository
    ) {
        suspend operator fun invoke(query: String): List<Book> {
            return if (query.isEmpty()) {
                repository.getAllBooks()
            } else {
                repository.searchBooksByTitle(query)
            }
        }
    }
    operator fun invoke(): List<Book> {
        return bookRepository.getAllBooks()
    }
}
