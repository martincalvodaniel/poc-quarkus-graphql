package com.dmartinc.pocgraphql.infrastructure.adapters.`in`.rest

import com.dmartinc.pocgraphql.core.Author
import com.dmartinc.pocgraphql.core.AuthorToCreate
import com.dmartinc.pocgraphql.core.Book
import com.dmartinc.pocgraphql.core.BookToCreate

data class AuthorDto(
    val id: String,
    val name: String,
    val country: String
) {
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
    fun toDomain() = AuthorToCreate(name, country)

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

data class BookWithoutAuthor(
    var id: String,
    var title: String,
    var summary: String
) {
    companion object {
        fun fromDomain(book: Book) = BookWithoutAuthor(book.id, book.title, book.summary)
    }
}

data class BookWithoutIdNorAuthor(
    var title: String,
    var summary: String
) {
    fun toDomain(authorId: String) = BookToCreate(authorId, title, summary)
}

data class BookWithoutIdDto(
    var authorId: String,
    var title: String,
    var summary: String
) {
    fun toDomain() = BookToCreate(authorId, title, summary)

    companion object {
        fun fromDomain(book: Book) = BookWithoutIdDto(book.authorId, book.title, book.summary)
    }
}

data class BookWithoutSummaryDto(
    var id: String,
    var title: String,
    var authorId: String
) {

    companion object {
        fun fromDomain(book: Book) = BookWithoutSummaryDto(book.id, book.title, book.authorId)
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
