package com.dmartinc.pocgraphql.app

import com.dmartinc.pocgraphql.core.ports.AuthorByIdRetriever
import com.dmartinc.pocgraphql.core.ports.AuthorsRetriever
import com.dmartinc.pocgraphql.core.ports.BookByIdRetriever
import com.dmartinc.pocgraphql.core.ports.BooksByAuthorIdRetriever
import com.dmartinc.pocgraphql.core.ports.BooksRetriever
import com.dmartinc.pocgraphql.core.usecases.queries.FindAuthor
import com.dmartinc.pocgraphql.core.usecases.queries.FindAuthors
import com.dmartinc.pocgraphql.core.usecases.queries.FindBook
import com.dmartinc.pocgraphql.core.usecases.queries.FindBooks
import io.quarkus.arc.DefaultBean
import javax.enterprise.context.Dependent
import javax.enterprise.inject.Produces

@Dependent
class UseCasesConfig(
    val authorByIdRetriever: AuthorByIdRetriever,
    val authorsRetriever: AuthorsRetriever,
    val bookByIdRetriever: BookByIdRetriever,
    val booksByAuthorIdRetriever: BooksByAuthorIdRetriever,
    val booksRetriever: BooksRetriever
) {

    @Produces
    @DefaultBean
    fun findAuthor(): FindAuthor = FindAuthor(authorByIdRetriever, booksByAuthorIdRetriever)

    @Produces
    @DefaultBean
    fun findAuthors(): FindAuthors = FindAuthors(authorsRetriever, booksByAuthorIdRetriever)

    @Produces
    @DefaultBean
    fun findBook(): FindBook = FindBook(bookByIdRetriever)

    @Produces
    @DefaultBean
    fun findBooks(): FindBooks = FindBooks(booksRetriever)
}
