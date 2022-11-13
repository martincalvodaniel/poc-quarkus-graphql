package com.dmartinc.pocgraphql.infrastructure.adapters.`in`.graphql

import com.dmartinc.pocgraphql.core.Author
import com.dmartinc.pocgraphql.core.Book

data class AuthorDto(
    var id: Int? = null,
    var name: String? = null,
    var country: String? = null
) {
    constructor() : this(null)

    fun toDomain() = Author(id!!, name!!, country!!)

    companion object {
        fun fromDomain(author: Author) =
            AuthorDto(author.id, author.name, author.country)
    }
}

data class AuthorsDto(var authors: List<AuthorDto>) {
    companion object {
        fun fromDomain(authors: List<Author>) = AuthorsDto(authors.map { AuthorDto.fromDomain(it) })
    }
}

data class BookDto(
    var id: Int? = null,
    var author: Int? = null,
    var title: String? = null,
    var summary: String? = null
) {
    constructor() : this(null)

    fun toDomain() = Book(id!!, author!!, title!!, summary!!)

    companion object {
        fun fromDomain(book: Book) = BookDto(book.id, book.author, book.title, book.summary)
    }
}

data class BooksDto(var books: List<BookDto>) {
    companion object {
        fun fromDomain(books: List<Book>) = BooksDto(books.map { BookDto.fromDomain(it) })
    }
}
