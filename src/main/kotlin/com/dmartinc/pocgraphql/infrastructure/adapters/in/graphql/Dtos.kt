package com.dmartinc.pocgraphql.infrastructure.adapters.`in`.graphql

import com.dmartinc.pocgraphql.core.Author
import com.dmartinc.pocgraphql.core.AuthorToCreate
import com.dmartinc.pocgraphql.core.Book
import com.dmartinc.pocgraphql.core.BookToCreate

data class AuthorToCreateDto(
    var name: String? = null,
    var country: String? = null
) {
    constructor() : this(null)

    fun toDomain() = AuthorToCreate(name!!, country!!)
}

data class AuthorDto(
    var id: String? = null,
    var name: String? = null,
    var country: String? = null
) {
    constructor() : this(null)

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

data class BookToCreateDto(
    var authorId: String? = null,
    var title: String? = null,
    var summary: String? = null
) {
    constructor() : this(null)

    fun toDomain() = BookToCreate(authorId!!, title!!, summary!!)
}

data class BookDto(
    var id: String? = null,
    var authorId: String? = null,
    var title: String? = null,
    var summary: String? = null
) {
    constructor() : this(null)

    companion object {
        fun fromDomain(book: Book) = BookDto(book.id, book.authorId, book.title, book.summary)
    }
}

data class BooksDto(var books: List<BookDto>) {
    companion object {
        fun fromDomain(books: List<Book>) = BooksDto(books.map { BookDto.fromDomain(it) })
    }
}
