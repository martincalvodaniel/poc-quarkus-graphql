package com.dmartinc.pocgraphql.infrastructure

import com.dmartinc.pocgraphql.core.Author
import com.dmartinc.pocgraphql.core.Book
import com.dmartinc.pocgraphql.core.ports.BookByIdRetriever
import com.dmartinc.pocgraphql.core.ports.BooksByAuthorRetriever
import com.dmartinc.pocgraphql.core.ports.BooksRetriever
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

class PanacheBooksRetriever :
    BookByIdRetriever,
    BooksByAuthorRetriever,
    BooksRetriever,
    PanacheRepository<PanacheBooksRetriever.BookEntity> {

    override fun retrieve(bookId: Int): Book? = find("id", bookId).firstResult()?.toDomain()

    override fun retrieve(author: Author): List<Book> =
        find("author", author.id).stream().map { it.toDomain() }.toList()

    override fun retrieve(): List<Book> = findAll().stream().map { it.toDomain() }.toList()

    @Entity(name = "BOOK")
    class BookEntity {
        @Id
        var id: Int? = null

        var author: Int? = null

        lateinit var title: String

        @Column(length = 1024)
        lateinit var summary: String

        fun toDomain() = Book(id!!, author!!, title, summary)
    }
}
