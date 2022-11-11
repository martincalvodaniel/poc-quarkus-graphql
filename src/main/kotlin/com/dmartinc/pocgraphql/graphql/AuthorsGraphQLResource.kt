package com.dmartinc.pocgraphql.graphql

import com.dmartinc.pocgraphql.core.usecases.queries.FindAuthor
import com.dmartinc.pocgraphql.core.usecases.queries.FindAuthors
import org.eclipse.microprofile.graphql.GraphQLApi
import org.eclipse.microprofile.graphql.Query

@GraphQLApi
class AuthorsGraphQLResource(
    private val findAuthor: FindAuthor,
    private val findAuthors: FindAuthors
) {

    @Query
    fun findAuthor(id: Int): AuthorDto = findAuthor.query(id).let { AuthorDto.fromDomain(it) }

    @Query
    fun findAuthors(): AuthorsDto = AuthorsDto.fromDomain(findAuthors.query())
}
