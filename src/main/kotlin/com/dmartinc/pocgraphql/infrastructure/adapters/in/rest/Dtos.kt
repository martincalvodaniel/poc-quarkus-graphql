package com.dmartinc.pocgraphql.infrastructure.adapters.`in`.rest

import com.dmartinc.pocgraphql.core.Author
import com.dmartinc.pocgraphql.core.AuthorAndBooks
import com.dmartinc.pocgraphql.core.Book

data class AuthorsDto(val authors: List<AuthorDto>) {

    companion object {
        fun fromDomain(authorAndBooks: List<AuthorAndBooks>) =
            AuthorsDto(authorAndBooks.map { AuthorDto.fromDomain(it) })
    }
}

data class AuthorDto(
    val id: Int,
    val name: String,
    val country: String,
    val books: List<BookDto>
) {
    fun toDomain() = Author(id, name, country)

    companion object {
        fun fromDomain(authorAndBooks: AuthorAndBooks) =
            AuthorDto(
                authorAndBooks.author.id,
                authorAndBooks.author.name,
                authorAndBooks.author.country,
                authorAndBooks.books.map { BookDto.fromDomain(it) }
            )
    }
}

data class BookDto(
    var id: Int,
    var author: Int,
    var title: String,
    var summary: String
) {

    companion object {
        fun fromDomain(book: Book) = BookDto(book.id, book.author, book.title, book.summary)
    }
}
