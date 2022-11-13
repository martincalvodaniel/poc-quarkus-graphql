package com.dmartinc.pocgraphql.app

import com.dmartinc.pocgraphql.core.ports.AuthorRemover
import com.dmartinc.pocgraphql.core.ports.AuthorRetriever
import com.dmartinc.pocgraphql.core.ports.AuthorsRetriever
import com.dmartinc.pocgraphql.core.ports.AuthorsStore
import com.dmartinc.pocgraphql.core.ports.BookRemover
import com.dmartinc.pocgraphql.core.ports.BookRetriever
import com.dmartinc.pocgraphql.core.ports.BooksRetriever
import com.dmartinc.pocgraphql.core.ports.BooksStore
import com.dmartinc.pocgraphql.core.usecases.actions.CreateAuthor
import com.dmartinc.pocgraphql.core.usecases.actions.CreateBook
import com.dmartinc.pocgraphql.core.usecases.actions.DeleteAuthor
import com.dmartinc.pocgraphql.core.usecases.actions.DeleteBook
import com.dmartinc.pocgraphql.core.usecases.queries.FindAuthor
import com.dmartinc.pocgraphql.core.usecases.queries.FindAuthors
import com.dmartinc.pocgraphql.core.usecases.queries.FindBook
import com.dmartinc.pocgraphql.core.usecases.queries.FindBooks
import io.quarkus.arc.DefaultBean
import javax.enterprise.context.Dependent
import javax.enterprise.inject.Produces

@Dependent
class UseCasesConfig(
    private val authorRetriever: AuthorRetriever,
    private val authorRemover: AuthorRemover,
    private val authorsRetriever: AuthorsRetriever,
    private val authorsStore: AuthorsStore,
    private val bookRetriever: BookRetriever,
    private val bookRemover: BookRemover,
    private val booksRetriever: BooksRetriever,
    private val booksStore: BooksStore
) {

    @Produces
    @DefaultBean
    fun createAuthor(): CreateAuthor = CreateAuthor(authorsStore)

    @Produces
    @DefaultBean
    fun createBook(): CreateBook = CreateBook(booksStore)

    @Produces
    @DefaultBean
    fun deleteAuthor(): DeleteAuthor = DeleteAuthor(authorRemover)

    @Produces
    @DefaultBean
    fun deleteBook(): DeleteBook = DeleteBook(bookRemover)

    @Produces
    @DefaultBean
    fun findAuthor(): FindAuthor = FindAuthor(authorRetriever)

    @Produces
    @DefaultBean
    fun findAuthors(): FindAuthors = FindAuthors(authorsRetriever)

    @Produces
    @DefaultBean
    fun findBook(): FindBook = FindBook(bookRetriever)

    @Produces
    @DefaultBean
    fun findBooks(): FindBooks = FindBooks(booksRetriever)
}
