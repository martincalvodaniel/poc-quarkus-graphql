package com.dmartinc.pocgraphql.graphql

import com.dmartinc.pocgraphql.core.usecases.queries.FindAuthor
import com.dmartinc.pocgraphql.core.usecases.queries.FindAuthors
import com.dmartinc.pocgraphql.core.usecases.queries.FindBook
import com.dmartinc.pocgraphql.core.usecases.queries.FindBooks
import com.dmartinc.pocgraphql.core.usecases.queries.FindBooksByAuthor
import org.eclipse.microprofile.graphql.GraphQLApi
import org.eclipse.microprofile.graphql.Query
import org.eclipse.microprofile.graphql.Source

@GraphQLApi
class PocGraphQLResource(
    private val findAuthor: FindAuthor,
    private val findAuthors: FindAuthors,
    private val findBook: FindBook,
    private val findBooks: FindBooks,
    private val findBooksByAuthor: FindBooksByAuthor
) {

    @Query
    fun findAuthor(id: Int): AuthorDto = findAuthor.query(id).let { AuthorDto.fromDomain(it) }

    @Query
    fun findAuthors(): AuthorsDto = AuthorsDto.fromDomain(findAuthors.query())

    @Query
    fun findBook(id: Int): BookDto = findBook.query(id).let { BookDto.fromDomain(it) }

    @Query
    fun findBooks(): BooksDto = BooksDto.fromDomain(findBooks.query())

    @Query("books")
    fun findBooksForAuthor(@Source authorDto: AuthorDto): List<BookDto> =
        findBooksByAuthor.query(authorDto.toDomain()).map { BookDto.fromDomain(it) }
}
