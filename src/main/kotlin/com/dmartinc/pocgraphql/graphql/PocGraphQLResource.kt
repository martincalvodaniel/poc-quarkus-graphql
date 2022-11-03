package com.dmartinc.pocgraphql.graphql

import com.dmartinc.pocgraphql.core.ports.AuthorsRetriever
import com.dmartinc.pocgraphql.core.ports.BooksRetriever
import org.eclipse.microprofile.graphql.Description
import org.eclipse.microprofile.graphql.GraphQLApi
import org.eclipse.microprofile.graphql.Query

@GraphQLApi
class PocGraphQLResource(
    private val authorsRetriever: AuthorsRetriever,
    private val booksRetriever: BooksRetriever
) {

    @Query
    @Description("Find Author")
    fun findAuthor(id: Int): AuthorDto = authorsRetriever.retrieve(id)
        ?.let { AuthorDto.fromDomain(it) }
        ?: throw AuthorNotFound()

    @Query
    @Description("Find Authors")
    fun findAuthors(): AuthorsDto = AuthorsDto.fromDomain(authorsRetriever.retrieve())

    @Query
    @Description("Find Book")
    fun findBook(id: Int): BookDto = booksRetriever.retrieve(id)
        ?.let { BookDto.fromDomain(it) }
        ?: throw BookNotFound()

    @Query
    @Description("Find Books")
    fun findBooks(): BooksDto = BooksDto.fromDomain(booksRetriever.retrieve())
}
