package com.dmartinc.pocgraphql.core.usecases.queries

import com.dmartinc.pocgraphql.core.AuthorAndBooks
import com.dmartinc.pocgraphql.core.ports.AuthorsRetriever
import com.dmartinc.pocgraphql.core.ports.BooksByAuthorRetriever

class FindAuthorsAndBooks(
    private val authorsRetriever: AuthorsRetriever,
    private val booksByAuthorRetriever: BooksByAuthorRetriever
) {

    fun query(): List<AuthorAndBooks> =
        authorsRetriever.retrieve()
            .map { AuthorAndBooks(it, booksByAuthorRetriever.retrieve(it)) }
}
