package com.dmartinc.pocgraphql.core.usecases.queries

import com.dmartinc.pocgraphql.core.Author
import com.dmartinc.pocgraphql.core.ports.AuthorsRetriever
import com.dmartinc.pocgraphql.core.ports.BooksByAuthorIdRetriever

class FindAuthors(
    private val authorsRetriever: AuthorsRetriever,
    private val booksByAuthorIdRetriever: BooksByAuthorIdRetriever
) {

    fun query(): List<Author> =
        authorsRetriever.retrieve()
            .map { it.copy(books = booksByAuthorIdRetriever.retrieveByAuthorId(it.id)) }
}
