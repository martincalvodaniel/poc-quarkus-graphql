package com.dmartinc.pocgraphql.infrastructure.adapters.out.panache

import com.dmartinc.pocgraphql.core.Book
import com.dmartinc.pocgraphql.core.BookToCreate
import com.dmartinc.pocgraphql.core.ports.BookRemover
import com.dmartinc.pocgraphql.core.ports.BookRetriever
import com.dmartinc.pocgraphql.core.ports.BooksRetriever
import com.dmartinc.pocgraphql.core.ports.BooksStore
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

class PanacheBooksRepository :
    BookRemover,
    BookRetriever,
    BooksRetriever,
    BooksStore,
    PanacheRepository<PanacheBooksRepository.BookEntity> {

    override fun remove(id: String) = deleteById(id.toLong())

    override fun retrieveOne(id: String) = findById(id.toLong())?.toDomain()

    override fun retrieve(authorId: String?) = (authorId?.let { list("authorId", authorId) } ?: listAll()).toDomain()

    override fun store(bookToCreate: BookToCreate) = persistAndFlush(BookEntity.fromDomain(bookToCreate))

    private fun List<BookEntity>.toDomain() = map { it.toDomain() }

    @Entity(name = "BOOK")
    class BookEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null

        var authorId: String? = null

        lateinit var title: String

        @Column(length = 1024)
        lateinit var summary: String

        companion object {
            fun fromDomain(bookToCreate: BookToCreate): BookEntity {
                val bookEntity = BookEntity()
                with(bookEntity) {
                    this.authorId = bookToCreate.authorId
                    this.title = bookToCreate.title
                    this.summary = bookToCreate.summary
                }
                return bookEntity
            }
        }

        fun toDomain() = Book(id!!.toString(), authorId!!, title, summary)
    }
}
