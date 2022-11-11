package com.dmartinc.pocgraphql.app

import com.dmartinc.pocgraphql.core.ports.AuthorByIdRetriever
import com.dmartinc.pocgraphql.core.ports.AuthorsRetriever
import com.dmartinc.pocgraphql.core.ports.BookByIdRetriever
import com.dmartinc.pocgraphql.core.ports.BooksByAuthorIdRetriever
import com.dmartinc.pocgraphql.core.ports.BooksRetriever
import com.dmartinc.pocgraphql.infrastructure.PanacheAuthorsRetriever
import com.dmartinc.pocgraphql.infrastructure.PanacheBooksRetriever
import io.quarkus.arc.DefaultBean
import javax.enterprise.context.Dependent
import javax.enterprise.inject.Produces

@Dependent
class PortsConfig {

    private val panacheAuthorsRetriever = PanacheAuthorsRetriever()

    private val panacheBooksRetriever = PanacheBooksRetriever()

    @Produces
    @DefaultBean
    fun authorByIdRetriever(): AuthorByIdRetriever = panacheAuthorsRetriever

    @Produces
    @DefaultBean
    fun authorsRetriever(): AuthorsRetriever = panacheAuthorsRetriever

    @Produces
    @DefaultBean
    fun bookByIdRetriever(): BookByIdRetriever = panacheBooksRetriever

    @Produces
    @DefaultBean
    fun booksByAuthorIdRetriever(): BooksByAuthorIdRetriever = panacheBooksRetriever

    @Produces
    @DefaultBean
    fun booksRetriever(): BooksRetriever = panacheBooksRetriever
}
