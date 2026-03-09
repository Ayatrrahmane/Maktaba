package com.ElOuedUniv.maktaba.data.repository

import com.ElOuedUniv.maktaba.data.model.Book


class BookRepository {



    private val booksList = listOf(
        Book(isbn = "97801353598548", title = "Clean Code", nbPages = 672),
        Book(isbn = "9788131722428", title = "The Pragmatic Programmer", nbPages = 352),
        Book(isbn = "9780134494326", title = "Architecture code", nbPages = 432),
        Book(isbn = "9780321356680", title = "Effective Java", nbPages = 416),
        Book(isbn = "9780596520687", title = "Head First Design Patterns", nbPages =694 ),
        Book(isbn = "9780262033848", title = "Interoduction to Algorithms", nbPages = 1312),
        Book(isbn = "9780596520687", title = "Head Fist Desing Patterns", nbPages = 694),
        Book(isbn = "9781491947096", title = "Android Programming", nbPages = 864),
        Book(isbn = "9780135359854", title = "Pro python Best Parities", nbPages = 246),
        Book(isbn = "9780135359853", title = "Head First Design Patterns", nbPages =694 )
    )



    fun getAllBooks(): List<Book> {
        return booksList
    }

    fun getBookByIsbn(isbn: String): Book? {
        return booksList.find { it.isbn == isbn }
    }
    fun searchBooksByTitle(query: String): List<Book> {
        return booksList.filter {
            it.title.contains(query, ignoreCase = true)
        }
  }
}