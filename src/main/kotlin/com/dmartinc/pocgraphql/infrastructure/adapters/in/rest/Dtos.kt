package com.dmartinc.pocgraphql.infrastructure.adapters.`in`.rest

import com.dmartinc.pocgraphql.core.Author
import com.dmartinc.pocgraphql.core.Book

data class AuthorDto(
    val id: Int,
    val name: String,
    val country: String
) {
    fun toDomain() = Author(id, name, country)

    companion object {
        fun fromDomain(author: Author) =
            AuthorDto(
                author.id,
                author.name,
                author.country
            )
    }
}

data class AuthorWithoutIdDto(
    val name: String,
    val country: String
) {
    companion object {
        fun fromDomain(author: Author) =
            AuthorWithoutIdDto(
                author.name,
                author.country
            )
    }
}
data class AuthorsDto(val authors: List<AuthorDto>) {
    companion object {
        fun fromDomain(authors: List<Author>) =
            AuthorsDto(authors.map { AuthorDto.fromDomain(it) })
    }
}

data class BookDto(
    var id: Int,
    var author: Int,
    var title: String,
    var summary: String
) {

    fun toDomain() = Book(id, author, title, summary)
}

data class BookWithoutAuthor(
    var id: Int,
    var title: String,
    var summary: String
) {

    fun toDomain(author: Int) = Book(id, author, title, summary)

    companion object {
        fun fromDomain(book: Book) = BookWithoutAuthor(book.id, book.title, book.summary)
    }
}

data class BookWithoutIdDto(
    var author: Int,
    var title: String,
    var summary: String
) {
    companion object {
        fun fromDomain(book: Book) = BookWithoutIdDto(book.author, book.title, book.summary)
    }
}

data class BookWithoutSummaryDto(
    var id: Int,
    var title: String,
    var author: Int
) {

    companion object {
        fun fromDomain(book: Book) = BookWithoutSummaryDto(book.id, book.title, book.author)
    }
}

data class BooksByAuthorIdDto(var books: List<BookWithoutAuthor>) {
    companion object {
        fun fromDomain(books: List<Book>) = BooksByAuthorIdDto(books.map { BookWithoutAuthor.fromDomain(it) })
    }
}

data class BooksDto(var books: List<BookWithoutSummaryDto>) {
    companion object {
        fun fromDomain(books: List<Book>) = BooksDto(books.map { BookWithoutSummaryDto.fromDomain(it) })
    }
}
