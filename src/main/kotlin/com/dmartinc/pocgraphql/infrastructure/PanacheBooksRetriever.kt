package com.dmartinc.pocgraphql.infrastructure

import com.dmartinc.pocgraphql.core.Book
import com.dmartinc.pocgraphql.core.ports.BooksRetriever
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepositoryBase
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

class PanacheBooksRetriever : BooksRetriever, PanacheRepositoryBase<PanacheBooksRetriever.BookEntity, Int> {

    override fun retrieve(id: Int): Book? = findById(id)?.toDomain()

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
