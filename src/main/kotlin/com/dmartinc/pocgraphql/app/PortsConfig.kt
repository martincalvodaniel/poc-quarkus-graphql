package com.dmartinc.pocgraphql.app

import com.dmartinc.pocgraphql.core.ports.AuthorRemover
import com.dmartinc.pocgraphql.core.ports.AuthorRetriever
import com.dmartinc.pocgraphql.core.ports.AuthorsRetriever
import com.dmartinc.pocgraphql.core.ports.AuthorsStore
import com.dmartinc.pocgraphql.core.ports.BookRemover
import com.dmartinc.pocgraphql.core.ports.BookRetriever
import com.dmartinc.pocgraphql.core.ports.BooksRetriever
import com.dmartinc.pocgraphql.core.ports.BooksStore

interface PortsConfig {
    fun authorRemover(): AuthorRemover

    fun authorRetriever(): AuthorRetriever

    fun authorsRetriever(): AuthorsRetriever

    fun authorsStore(): AuthorsStore

    fun bookRemover(): BookRemover

    fun bookRetriever(): BookRetriever

    fun booksRetriever(): BooksRetriever

    fun booksStore(): BooksStore
}
