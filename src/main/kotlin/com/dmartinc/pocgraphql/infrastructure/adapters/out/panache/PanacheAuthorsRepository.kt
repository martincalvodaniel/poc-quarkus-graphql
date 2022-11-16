package com.dmartinc.pocgraphql.infrastructure.adapters.out.panache

import com.dmartinc.pocgraphql.core.Author
import com.dmartinc.pocgraphql.core.AuthorToCreate
import com.dmartinc.pocgraphql.core.ports.AuthorRemover
import com.dmartinc.pocgraphql.core.ports.AuthorRetriever
import com.dmartinc.pocgraphql.core.ports.AuthorsRetriever
import com.dmartinc.pocgraphql.core.ports.AuthorsStore
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

class PanacheAuthorsRepository :
    AuthorRemover,
    AuthorsRetriever,
    AuthorRetriever,
    AuthorsStore,
    PanacheRepository<PanacheAuthorsRepository.AuthorEntity> {

    override fun remove(id: String) = deleteById(id.toLong())

    override fun retrieve(id: String) = findById(id.toLong())?.toDomain()

    override fun retrieve() = listAll().map { it.toDomain() }.toList()

    override fun store(authorToCreate: AuthorToCreate) = persistAndFlush(AuthorEntity.fromDomain(authorToCreate))

    @Entity(name = "AUTHOR")
    class AuthorEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null
        lateinit var name: String
        lateinit var country: String

        fun toDomain() = Author(id!!.toString(), name, country)

        companion object {
            fun fromDomain(authorToCreate: AuthorToCreate): AuthorEntity {
                val authorEntity = AuthorEntity()
                with(authorEntity) {
                    this.name = authorToCreate.name
                    this.country = authorToCreate.country
                }
                return authorEntity
            }
        }
    }
}
