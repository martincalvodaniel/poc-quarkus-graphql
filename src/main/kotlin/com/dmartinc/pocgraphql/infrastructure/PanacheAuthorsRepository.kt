package com.dmartinc.pocgraphql.infrastructure

import com.dmartinc.pocgraphql.core.Author
import com.dmartinc.pocgraphql.core.Book
import com.dmartinc.pocgraphql.core.ports.AuthorByIdRetriever
import com.dmartinc.pocgraphql.core.ports.AuthorsRetriever
import com.dmartinc.pocgraphql.core.ports.AuthorsStore
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepositoryBase
import javax.persistence.Entity
import javax.persistence.Id

class PanacheAuthorsRepository :
    AuthorsRetriever,
    AuthorByIdRetriever,
    AuthorsStore,
    PanacheRepositoryBase<PanacheAuthorsRepository.AuthorEntity, Int> {

    override fun retrieve(id: Int): Author? = findById(id)?.toDomain()

    override fun retrieve(): List<Author> = listAll().map { it.toDomain() }.toList()

    override fun store(author: Author) = persistAndFlush(AuthorEntity.fromDomain(author))

    @Entity(name = "AUTHOR")
    class AuthorEntity {
        @Id var id: Int? = null
        lateinit var name: String
        lateinit var country: String

        fun toDomain() = Author(id!!, name, country)

        companion object {
            fun fromDomain(author: Author): AuthorEntity {
                val authorEntity = AuthorEntity()
                with(authorEntity) {
                    this.id = author.id
                    this.name = author.name
                    this.country = author.country
                }
                return authorEntity
            }
        }
    }
}
