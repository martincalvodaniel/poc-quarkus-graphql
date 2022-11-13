package com.dmartinc.pocgraphql.infrastructure.adapters.`in`.graphql

import com.dmartinc.pocgraphql.core.usecases.actions.CreateAuthor
import com.dmartinc.pocgraphql.core.usecases.actions.DeleteAuthor
import com.dmartinc.pocgraphql.core.usecases.queries.FindAuthor
import com.dmartinc.pocgraphql.core.usecases.queries.FindAuthors
import org.eclipse.microprofile.graphql.GraphQLApi
import org.eclipse.microprofile.graphql.Mutation
import org.eclipse.microprofile.graphql.Query
import javax.transaction.Transactional

@GraphQLApi
class AuthorsGraphQLResource(
    private val createAuthor: CreateAuthor,
    private val deleteAuthor: DeleteAuthor,
    private val findAuthor: FindAuthor,
    private val findAuthors: FindAuthors
) {

    @Transactional
    @Mutation
    fun createAuthor(author: AuthorDto): Boolean {
        createAuthor.execute(author.toDomain())
        return true
    }

    @Transactional
    @Mutation
    fun deleteAuthor(id: Int): Boolean {
        deleteAuthor.execute(id)
        return true
    }

    @Query
    fun findAuthor(id: Int): AuthorDto = findAuthor.query(id).let { AuthorDto.fromDomain(it) }

    @Query
    fun findAuthors(): AuthorsDto = AuthorsDto.fromDomain(findAuthors.query())
}
