package com.dmartinc.pocgraphql.infrastructure

import com.dmartinc.pocgraphql.core.Author
import com.dmartinc.pocgraphql.core.ports.AuthorsRetriever
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepositoryBase
import javax.persistence.Entity
import javax.persistence.Id

class PanacheAuthorsRetriever : AuthorsRetriever, PanacheRepositoryBase<PanacheAuthorsRetriever.AuthorEntity, Int> {

    override fun retrieve(id: Int): Author? = findById(id)?.toDomain()

    override fun retrieve(): List<Author> = findAll().stream().map { it.toDomain() }.toList()

    @Entity(name = "AUTHOR")
    class AuthorEntity {
        @Id var id: Int? = null
        lateinit var name: String
        lateinit var country: String

        fun toDomain() = Author(id!!, name, country)
    }
}
