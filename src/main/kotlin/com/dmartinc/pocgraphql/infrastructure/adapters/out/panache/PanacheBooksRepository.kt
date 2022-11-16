package com.dmartinc.pocgraphql.infrastructure.adapters.out.panache

import com.dmartinc.pocgraphql.core.Book
import com.dmartinc.pocgraphql.core.ports.BookRemover
import com.dmartinc.pocgraphql.core.ports.BookRetriever
import com.dmartinc.pocgraphql.core.ports.BooksRetriever
import com.dmartinc.pocgraphql.core.ports.BooksStore
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepositoryBase
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

class PanacheBooksRepository :
    BookRemover,
    BookRetriever,
    BooksRetriever,
    BooksStore,
    PanacheRepositoryBase<PanacheBooksRepository.BookEntity, String> {

    override fun remove(id: String) = deleteById(id)

    override fun retrieveOne(id: String) = findById(id)?.toDomain()

    override fun retrieve(authorId: String?) = (authorId?.let { list("authorId", authorId) } ?: listAll()).toDomain()

    override fun store(book: Book) = persistAndFlush(BookEntity.fromDomain(book))

    private fun List<BookEntity>.toDomain() = map { it.toDomain() }

    @Entity(name = "BOOK")
    class BookEntity {
        @Id
        var id: String? = null

        var authorId: String? = null

        lateinit var title: String

        @Column(length = 1024)
        lateinit var summary: String

        companion object {
            fun fromDomain(book: Book): BookEntity {
                val bookEntity = BookEntity()
                with(bookEntity) {
                    this.id = book.id
                    this.authorId = book.authorId
                    this.title = book.title
                    this.summary = book.summary
                }
                return bookEntity
            }
        }

        fun toDomain() = Book(id!!, authorId!!, title, summary)
    }
}
