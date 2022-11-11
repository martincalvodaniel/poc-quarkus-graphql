package com.dmartinc.pocgraphql.graphql

import com.dmartinc.pocgraphql.core.usecases.queries.FindAuthor
import com.dmartinc.pocgraphql.core.usecases.queries.FindAuthors
import com.dmartinc.pocgraphql.core.usecases.queries.FindBook
import com.dmartinc.pocgraphql.core.usecases.queries.FindBooks
import org.eclipse.microprofile.graphql.Description
import org.eclipse.microprofile.graphql.GraphQLApi
import org.eclipse.microprofile.graphql.Query

@GraphQLApi
class PocGraphQLResource(
    private val findAuthor: FindAuthor,
    private val findAuthors: FindAuthors,
    private val findBook: FindBook,
    private val findBooks: FindBooks
) {

    @Query
    @Description("Find Author")
    fun findAuthor(id: Int): AuthorDto = findAuthor.query(id).let { AuthorDto.fromDomain(it) }

    @Query
    @Description("Find Authors")
    fun findAuthors(): AuthorsDto = AuthorsDto.fromDomain(findAuthors.query())

    @Query
    @Description("Find Book")
    fun findBook(id: Int): BookDto = findBook.query(id).let { BookDto.fromDomain(it) }

    @Query
    @Description("Find Books")
    fun findBooks(): BooksDto = BooksDto.fromDomain(findBooks.query())
}
