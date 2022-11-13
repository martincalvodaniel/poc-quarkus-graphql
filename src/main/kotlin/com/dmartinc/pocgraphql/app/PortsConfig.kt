package com.dmartinc.pocgraphql.app

import com.dmartinc.pocgraphql.core.ports.AuthorByIdRetriever
import com.dmartinc.pocgraphql.core.ports.AuthorRemover
import com.dmartinc.pocgraphql.core.ports.AuthorsRetriever
import com.dmartinc.pocgraphql.core.ports.AuthorsStore
import com.dmartinc.pocgraphql.core.ports.BookByIdRetriever
import com.dmartinc.pocgraphql.core.ports.BookRemover
import com.dmartinc.pocgraphql.core.ports.BooksByAuthorIdRetriever
import com.dmartinc.pocgraphql.core.ports.BooksRetriever
import com.dmartinc.pocgraphql.core.ports.BooksStore

interface PortsConfig {
    fun authorByIdRetriever(): AuthorByIdRetriever

    fun authorRemover(): AuthorRemover

    fun authorsRetriever(): AuthorsRetriever

    fun authorsStore(): AuthorsStore

    fun bookByIdRetriever(): BookByIdRetriever

    fun booksByAuthorIdRetriever(): BooksByAuthorIdRetriever

    fun bookRemover(): BookRemover

    fun booksRetriever(): BooksRetriever

    fun booksStore(): BooksStore
}
