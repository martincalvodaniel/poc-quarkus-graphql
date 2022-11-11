package com.dmartinc.pocgraphql.core.usecases.queries

import com.dmartinc.pocgraphql.core.Book
import com.dmartinc.pocgraphql.core.ports.BookByIdRetriever
import com.dmartinc.pocgraphql.graphql.AuthorNotFound

class FindBook(private val bookByIdRetriever: BookByIdRetriever) {

    fun query(bookId: Int): Book =
        bookByIdRetriever.retrieve(bookId)
            ?: throw AuthorNotFound()
}
