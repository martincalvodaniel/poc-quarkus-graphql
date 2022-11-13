package com.dmartinc.pocgraphql.core

data class Author(val id: Int, val name: String, val country: String)

data class AuthorAndBooks(val author: Author, val books: List<Book>)

data class Book(val id: Int, val author: Int, val title: String, val summary: String)
