package com.dmartinc.pocgraphql.app

import com.dmartinc.pocgraphql.core.ports.AuthorByIdRetriever
import com.dmartinc.pocgraphql.core.ports.AuthorsRetriever
import com.dmartinc.pocgraphql.core.ports.AuthorsStore
import com.dmartinc.pocgraphql.core.ports.BookByIdRetriever
import com.dmartinc.pocgraphql.core.ports.BooksByAuthorRetriever
import com.dmartinc.pocgraphql.core.ports.BooksRetriever
import com.dmartinc.pocgraphql.core.ports.BooksStore
import com.dmartinc.pocgraphql.core.usecases.actions.CreateAuthor
import com.dmartinc.pocgraphql.core.usecases.actions.CreateBook
import com.dmartinc.pocgraphql.core.usecases.queries.FindAuthor
import com.dmartinc.pocgraphql.core.usecases.queries.FindAuthorAndBooks
import com.dmartinc.pocgraphql.core.usecases.queries.FindAuthors
import com.dmartinc.pocgraphql.core.usecases.queries.FindAuthorsAndBooks
import com.dmartinc.pocgraphql.core.usecases.queries.FindBook
import com.dmartinc.pocgraphql.core.usecases.queries.FindBooks
import com.dmartinc.pocgraphql.core.usecases.queries.FindBooksByAuthor
import io.quarkus.arc.DefaultBean
import javax.enterprise.context.Dependent
import javax.enterprise.inject.Produces

@Dependent
class UseCasesConfig(
    private val authorsStore: AuthorsStore,
    private val authorByIdRetriever: AuthorByIdRetriever,
    private val authorsRetriever: AuthorsRetriever,
    private val booksStore: BooksStore,
    private val bookByIdRetriever: BookByIdRetriever,
    private val booksByAuthorRetriever: BooksByAuthorRetriever,
    private val booksRetriever: BooksRetriever
) {

    @Produces
    @DefaultBean
    fun createAuthor(): CreateAuthor = CreateAuthor(authorsStore)

    @Produces
    @DefaultBean
    fun findAuthor(): FindAuthor = FindAuthor(authorByIdRetriever)

    @Produces
    @DefaultBean
    fun findAuthorAndBooks(): FindAuthorAndBooks = FindAuthorAndBooks(authorByIdRetriever, booksByAuthorRetriever)

    @Produces
    @DefaultBean
    fun findAuthors(): FindAuthors = FindAuthors(authorsRetriever)

    @Produces
    @DefaultBean
    fun findAuthorsAndBooks(): FindAuthorsAndBooks = FindAuthorsAndBooks(authorsRetriever, booksByAuthorRetriever)

    @Produces
    @DefaultBean
    fun createBook(): CreateBook = CreateBook(booksStore)

    @Produces
    @DefaultBean
    fun findBook(): FindBook = FindBook(bookByIdRetriever)

    @Produces
    @DefaultBean
    fun findBooks(): FindBooks = FindBooks(booksRetriever)

    @Produces
    @DefaultBean
    fun findBooksByAuthor(): FindBooksByAuthor = FindBooksByAuthor(booksByAuthorRetriever)
}
