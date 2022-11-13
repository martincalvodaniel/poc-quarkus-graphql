package com.dmartinc.pocgraphql.app

import com.dmartinc.pocgraphql.core.ports.AuthorByIdRetriever
import com.dmartinc.pocgraphql.core.ports.AuthorsRetriever
import com.dmartinc.pocgraphql.core.ports.AuthorsStore
import com.dmartinc.pocgraphql.core.ports.BookByIdRetriever
import com.dmartinc.pocgraphql.core.ports.BooksByAuthorIdRetriever
import com.dmartinc.pocgraphql.core.ports.BooksRetriever
import com.dmartinc.pocgraphql.core.ports.BooksStore
import com.dmartinc.pocgraphql.infrastructure.adapters.out.panache.PanacheAuthorsRepository
import com.dmartinc.pocgraphql.infrastructure.adapters.out.panache.PanacheBooksRepository
import io.quarkus.arc.DefaultBean
import javax.enterprise.context.Dependent
import javax.enterprise.inject.Produces

@Dependent
class PortsConfig {

    private val panacheAuthorsRepository = PanacheAuthorsRepository()

    private val panacheBooksRepository = PanacheBooksRepository()

    @Produces
    @DefaultBean
    fun authorByIdRetriever(): AuthorByIdRetriever = panacheAuthorsRepository

    @Produces
    @DefaultBean
    fun authorsRetriever(): AuthorsRetriever = panacheAuthorsRepository

    @Produces
    @DefaultBean
    fun authorsStore(): AuthorsStore = panacheAuthorsRepository

    @Produces
    @DefaultBean
    fun bookByIdRetriever(): BookByIdRetriever = panacheBooksRepository

    @Produces
    @DefaultBean
    fun booksByAuthorIdRetriever(): BooksByAuthorIdRetriever = panacheBooksRepository

    @Produces
    @DefaultBean
    fun booksRetriever(): BooksRetriever = panacheBooksRepository

    @Produces
    @DefaultBean
    fun booksStore(): BooksStore = panacheBooksRepository
}
