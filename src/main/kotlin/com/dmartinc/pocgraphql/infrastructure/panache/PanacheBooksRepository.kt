package com.dmartinc.pocgraphql.infrastructure.panache

import com.dmartinc.pocgraphql.core.Author
import com.dmartinc.pocgraphql.core.Book
import com.dmartinc.pocgraphql.core.ports.BookByIdRetriever
import com.dmartinc.pocgraphql.core.ports.BooksByAuthorRetriever
import com.dmartinc.pocgraphql.core.ports.BooksRetriever
import com.dmartinc.pocgraphql.core.ports.BooksStore
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepositoryBase
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

class PanacheBooksRepository :
    BookByIdRetriever,
    BooksByAuthorRetriever,
    BooksRetriever,
    BooksStore,
    PanacheRepositoryBase<PanacheBooksRepository.BookEntity, Int> {

    override fun retrieve(bookId: Int): Book? = findById(bookId)?.toDomain()

    override fun retrieve(author: Author): List<Book> = list("author", author.id).map { it.toDomain() }.toList()

    override fun retrieve(): List<Book> = listAll().map { it.toDomain() }.toList()

    override fun store(book: Book) = persistAndFlush(BookEntity.fromDomain(book))

    @Entity(name = "BOOK")
    class BookEntity {
        @Id
        var id: Int? = null

        var author: Int? = null

        lateinit var title: String

        @Column(length = 1024)
        lateinit var summary: String

        companion object {
            fun fromDomain(book: Book): BookEntity {
                val bookEntity = BookEntity()
                with(bookEntity) {
                    this.id = book.id
                    this.author = book.author
                    this.title = book.title
                    this.summary = book.summary
                }
                return bookEntity
            }
        }

        fun toDomain() = Book(id!!, author!!, title, summary)
    }
}
