package com.dmartinc.pocgraphql.infrastructure.adapters.out.panache

import com.dmartinc.pocgraphql.core.Author
import com.dmartinc.pocgraphql.core.ports.AuthorRetriever
import com.dmartinc.pocgraphql.core.ports.AuthorRemover
import com.dmartinc.pocgraphql.core.ports.AuthorsRetriever
import com.dmartinc.pocgraphql.core.ports.AuthorsStore
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepositoryBase
import javax.persistence.Entity
import javax.persistence.Id

class PanacheAuthorsRepository :
    AuthorRemover,
    AuthorsRetriever,
    AuthorRetriever,
    AuthorsStore,
    PanacheRepositoryBase<PanacheAuthorsRepository.AuthorEntity, Int> {

    override fun remove(id: Int) = deleteById(id)

    override fun retrieve(id: Int) = findById(id)?.toDomain()

    override fun retrieve() = listAll().map { it.toDomain() }.toList()

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
