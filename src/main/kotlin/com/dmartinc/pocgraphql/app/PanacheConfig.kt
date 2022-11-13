package com.dmartinc.pocgraphql.app

import com.dmartinc.pocgraphql.core.ports.AuthorRemover
import com.dmartinc.pocgraphql.core.ports.AuthorRetriever
import com.dmartinc.pocgraphql.core.ports.AuthorsRetriever
import com.dmartinc.pocgraphql.core.ports.AuthorsStore
import com.dmartinc.pocgraphql.core.ports.BookRemover
import com.dmartinc.pocgraphql.core.ports.BookRetriever
import com.dmartinc.pocgraphql.core.ports.BooksRetriever
import com.dmartinc.pocgraphql.core.ports.BooksStore
import com.dmartinc.pocgraphql.infrastructure.adapters.out.panache.PanacheAuthorsRepository
import com.dmartinc.pocgraphql.infrastructure.adapters.out.panache.PanacheBooksRepository
import io.quarkus.arc.DefaultBean
import javax.enterprise.context.Dependent
import javax.enterprise.inject.Produces

@Dependent
class PanacheConfig : PortsConfig {

    private val panacheAuthorsRepository = PanacheAuthorsRepository()

    private val panacheBooksRepository = PanacheBooksRepository()

    @Produces
    @DefaultBean
    override fun authorRemover(): AuthorRemover = panacheAuthorsRepository

    @Produces
    @DefaultBean
    override fun authorRetriever(): AuthorRetriever = panacheAuthorsRepository

    @Produces
    @DefaultBean
    override fun authorsRetriever(): AuthorsRetriever = panacheAuthorsRepository

    @Produces
    @DefaultBean
    override fun authorsStore(): AuthorsStore = panacheAuthorsRepository

    @Produces
    @DefaultBean
    override fun bookRemover(): BookRemover = panacheBooksRepository

    @Produces
    @DefaultBean
    override fun bookRetriever(): BookRetriever = panacheBooksRepository

    @Produces
    @DefaultBean
    override fun booksRetriever(): BooksRetriever = panacheBooksRepository

    @Produces
    @DefaultBean
    override fun booksStore(): BooksStore = panacheBooksRepository
}
