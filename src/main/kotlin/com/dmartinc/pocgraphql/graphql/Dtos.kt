package com.dmartinc.pocgraphql.graphql

import com.dmartinc.pocgraphql.core.Author
import com.dmartinc.pocgraphql.core.Book

data class AuthorDto(val id: Int, val name: String, val country: String) {
    companion object {
        fun fromDomain(author: Author) = AuthorDto(author.id, author.name, author.country)
    }
}

data class AuthorsDto(val authors: List<AuthorDto>) {
    companion object {
        fun fromDomain(authors: List<Author>) = AuthorsDto(authors.map { AuthorDto.fromDomain(it) })
    }
}

data class BookDto(val id: Int, val author: Int, val title: String, val summary: String) {
    companion object {
        fun fromDomain(book: Book) = BookDto(book.id, book.author, book.title, book.summary)
    }
}

data class BooksDto(val books: List<BookDto>) {
    companion object {
        fun fromDomain(books: List<Book>) = BooksDto(books.map { BookDto.fromDomain(it) })
    }
}
