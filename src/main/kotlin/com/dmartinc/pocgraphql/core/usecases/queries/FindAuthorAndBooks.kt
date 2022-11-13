package com.dmartinc.pocgraphql.core.usecases.queries

import com.dmartinc.pocgraphql.core.AuthorAndBooks
import com.dmartinc.pocgraphql.core.AuthorNotFound
import com.dmartinc.pocgraphql.core.ports.AuthorByIdRetriever
import com.dmartinc.pocgraphql.core.ports.BooksByAuthorRetriever

class FindAuthorAndBooks(
    private val authorByIdRetriever: AuthorByIdRetriever,
    private val booksByAuthorRetriever: BooksByAuthorRetriever
) {

    fun query(authorId: Int): AuthorAndBooks {
        val author = authorByIdRetriever.retrieve(authorId)
            ?: throw AuthorNotFound()
        val books = booksByAuthorRetriever.retrieve(author)
        return AuthorAndBooks(author, books)
    }
}
